package controllers.concrete.impl;

import Config.UserDB_Config;
import controllers.concrete.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserManager;
import service.UserService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAddToBlacklist implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Получаем имя пользователя из запроса
        String username = request.getParameter("username");

        // Если имя пользователя не пустое
        if (username != null && !username.isEmpty()) {
            // Создайте экземпляр UserService

            // Используйте метод `addUserToBlacklist` для добавления пользователя в черный список
            boolean success = UserManager.addUserToBlacklist(username);

            // Перенаправляем пользователя в зависимости от результата операции
            if (success) {
                response.sendRedirect("MyController?command=go_to_user_manager");
            } else {
                response.sendRedirect("MyController?command=go_to_user_manager&blackerror=An error occurred while adding user to blacklist");
            }
        }
    }
}