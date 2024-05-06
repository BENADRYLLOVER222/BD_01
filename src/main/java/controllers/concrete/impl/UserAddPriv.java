package controllers.concrete.impl;

import bean.AuthInfo;
import bean.User;
import controllers.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserManager;
import service.UserService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAddPriv implements Command {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем имя пользователя и новую роль из запроса
        String username = request.getParameter("useraddpriv");
        String privToAdd = request.getParameter("role_add");

        boolean success = UserManager.updateUserRole(username, privToAdd);

        // Перенаправляем пользователя на нужную страницу
        if (success) {
            response.sendRedirect("MyController?command=go_to_user_manager");
        } else {
            response.sendRedirect("MyController?command=go_to_user_manager&priverror=An error occurred while updating user role");
        }
    }
}
