package controllers.concrete.impl;

import bean.User;
import controllers.concrete.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class UserPrivChange implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Строка подключения к базе данных
        String url = "jdbc:postgresql://localhost:5432/user_database";
        // Учетные данные для подключения к базе данных
        String dbUser = "postgres";
        String password = "6666";

        // Перебираем всех пользователей
        Collection<User> allUsers = UserManager.getAllUsers();
        for (User user : allUsers) {
            // Формируем имена параметров для имени пользователя и новой роли
            String usernameParam = "username_" + user.getId();
            String newRoleParam = "newRole_" + user.getId();

            // Получаем значения имени пользователя и новой роли из запроса
            String username = request.getParameter(usernameParam);
            String newRole = request.getParameter(newRoleParam);

            // Если значения параметров не пустые, выполняем SQL-запрос для изменения роли пользователя
            if (username != null && !username.isEmpty() && newRole != null && !newRole.isEmpty()) {
                // SQL-запрос для изменения роли пользователя
                String sql = "UPDATE users_table SET role = ? WHERE name = ?";

                try (Connection conn = DriverManager.getConnection(url, dbUser, password);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    // Устанавливаем значения параметров для запроса
                    pstmt.setString(1, newRole);
                    pstmt.setString(2, username);

                    // Выполняем запрос
                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    // Обработка исключений
                    e.printStackTrace();
                }
            }
        }
        UserManager.refreshUserList();
        // Перенаправляем пользователя на страницу управления пользователями
        response.sendRedirect("MyController?command=go_to_user_manager");
    }
}