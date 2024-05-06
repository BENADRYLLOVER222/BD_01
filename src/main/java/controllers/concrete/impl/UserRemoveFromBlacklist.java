package controllers.concrete.impl;

import controllers.concrete.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRemoveFromBlacklist implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Получаем имя пользователя, которого нужно разблокировать, из запроса
        String mutedUserName = request.getParameter("mutedUserName");
        System.out.println(mutedUserName);

        // Если имя пользователя не пустое
        if (mutedUserName != null && !mutedUserName.isEmpty()) {
            // Строка подключения к базе данных
            String url = "jdbc:postgresql://localhost:5432/user_database";
            // Учетные данные для подключения к базе данных
            String dbUser = "postgres";
            String password = "6666";

            // SQL-запрос для обновления роли пользователя на 'user'
            String sql = "UPDATE users_table SET role = 'user' WHERE name = ?";

            try (Connection conn = DriverManager.getConnection(url, dbUser, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Устанавливаем значение параметра запроса
                pstmt.setString(1, mutedUserName);

                // Выполняем запрос
                pstmt.executeUpdate();

            } catch (SQLException e) {
                // Обработка исключений
                e.printStackTrace();
            }
        }

        // Перенаправляем пользователя на страницу управления пользователями
        response.sendRedirect("MyController?command=go_to_user_manager");
    }
}