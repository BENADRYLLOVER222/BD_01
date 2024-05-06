package service;

import Config.UserDB_Config;
import bean.News;
import bean.Tag;

import java.sql.*;
import java.util.*;

public class TagManager {

    private static final Map<Long, Tag> tagList = new HashMap<>();

    static{
        tagRefresh();
    }

    public static synchronized void tagRefresh() {
        try (Connection connection = DriverManager.getConnection(UserDB_Config.DB_URL, UserDB_Config.DB_USER, UserDB_Config.DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            // Выполнение запроса для загрузки данных из таблицы news
            ResultSet rs = statement.executeQuery("SELECT id, name FROM tags");

            // Очищаем список новостей
            tagList.clear();

            // Заполнение newsList из результатов запроса
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");

                // Создание объекта News из полученных данных
                Tag tag = new Tag(id, name);
                // Добавление новости в список новостей
                tagList.put(id, tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Tag getTagByName(String name) {
        // Перебираем теги в tagList, чтобы найти тег по имени
        for (Tag tag : tagList.values()) {
            if (tag.getName().equalsIgnoreCase(name)) {
                return tag; // Если найден тег с нужным именем, возвращаем его
            }
        }
        return null; // Если тег не найден, возвращаем null
    }

}
