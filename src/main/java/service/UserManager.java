package service;

import Config.UserDB_Config;
import bean.User;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public final class UserManager {
    private static final Map<Long, User> userList = new HashMap<>();

    // Приватный конструктор для предотвращения создания экземпляров
    private UserManager() {
        // Пустой приватный конструктор
    }

    static {
      refreshUserList();
    }

    // Метод для добавления пользователя
    public static synchronized void addUser(User user) {
        userList.put(user.getId(), user);
    }
    public static synchronized void refreshUserList() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Используем try-with-resources для автоматического закрытия ресурсов
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_database", "postgres", "6666");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users_table")) {
            userList.clear();

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String role = rs.getString("role");
                String password = rs.getString("password");

                // Создаем пользователя и добавляем его в userList
                User user = new User(id, name, role, password);
                userList.put(id, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean updateUserRole(String username, String newRole) {
        // Строка подключения к базе данных

        // SQL-запрос для изменения роли пользователя
        String sql = "UPDATE users_table SET role = ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(UserDB_Config.DB_URL, UserDB_Config.DB_USER, UserDB_Config.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Устанавливаем значения параметров в запрос
            pstmt.setString(1, newRole); // Устанавливаем новую роль
            pstmt.setString(2, username); // Устанавливаем имя пользователя

            // Выполняем запрос
            pstmt.executeUpdate();

            // Обновляем список пользователей в `UserManager`
            UserManager.refreshUserList();

            // Возвращаем true, если операция успешна
            return true;

        } catch (SQLException e) {
            // Обработка исключений
            e.printStackTrace();
            // Возвращаем false, если произошла ошибка
            return false;
        }
    }

    // Метод для добавления пользователя в черный список
    public static boolean addUserToBlacklist(String username) {
        // SQL-запрос для изменения роли пользователя на 'muted'
        String sql = "UPDATE users_table SET role = 'muted' WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(UserDB_Config.DB_URL, UserDB_Config.DB_USER, UserDB_Config.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Устанавливаем значение параметра запроса
            pstmt.setString(1, username);

            // Выполняем запрос
            pstmt.executeUpdate();

            // Возвращаем true, если операция успешна
            return true;

        } catch (SQLException e) {
            // Обработка исключений
            e.printStackTrace();
            // Возвращаем false в случае ошибки
            return false;
        }
    }


    // Метод для получения пользователя по логину
    public static synchronized User getUserByUsername(String username) {
        // Проходимся по всем записям в карте userList
        for (User user : userList.values()) {
            // Проверяем, соответствует ли имя пользователя переданному параметру username
            if (user.getName().equals(username)) {
                // Возвращаем объект User, если имя совпадает
                return user;
            }
        }
        // Если не найдено совпадений, возвращаем null
        return null;
    }

    // Метод для аутентификации пользователя по имени пользователя и паролю
    public static synchronized User authenticateUser(String username, String password) {
        // Получаем пользователя по логину
        User user = userList.get(username);
        // Если пользователь найден и пароль совпадает, возвращаем пользователя
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        // Если аутентификация не удалась, возвращаем null
        return null;
    }

    // Метод для получения всех пользователей
    public static synchronized Collection<User> getAllUsers() {
        return userList.values();
    }
}