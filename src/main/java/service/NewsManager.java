package service;

import java.sql.*;
import java.util.*;

import Config.UserDB_Config;
import bean.News;

public final class NewsManager {

    // Статический список новостей
    private static final Map<Long, News> newsList = new HashMap<>();

    // Приватный конструктор для предотвращения создания экземпляров
    private NewsManager() {
        // Пустой приватный конструктор
    }

    static {
        newsRefresh();
    }
    public static synchronized void newsRefresh() {
        try (Connection connection = DriverManager.getConnection(UserDB_Config.DB_URL, UserDB_Config.DB_USER, UserDB_Config.DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            // Выполнение запроса для загрузки данных из таблицы news
            ResultSet rs = statement.executeQuery("SELECT id, title, brief, info, img_path FROM news");

            // Очищаем список новостей
            newsList.clear();

            // Заполнение newsList из результатов запроса
            while (rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String brief = rs.getString("brief");
                String info = rs.getString("info");
                String imgPath = rs.getString("img_path");

                // Создание объекта News из полученных данных
                News news = new News(id, title, brief, info, imgPath, null);
                // Добавление новости в список новостей
                newsList.put(id, news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для добавления новости
    public static synchronized void addNews(News news) {
        // Добавьте новость в хешмап с ключом news.getId()
        newsList.put(news.getId(), news);
    }

    // Метод для удаления новости по индексу
    public static synchronized void removeNews(long id) {
        newsList.remove(id);
    }


    // Метод для получения всех новостей
    public static synchronized Collection<News> getAllNews() {
        // Возвращаем коллекцию всех новостей из newsMap
        return newsList.values();
    }

    // Метод для получения новости по id
    public static synchronized News getNewsById(long id) {
        return newsList.get(id);
    }
}