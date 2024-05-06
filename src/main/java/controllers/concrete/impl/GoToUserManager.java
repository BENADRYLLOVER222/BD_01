package controllers.concrete.impl;

import bean.News;
import bean.User;
import controllers.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.NewsManager;
import service.UserManager;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GoToUserManager implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserManager.refreshUserList();
        if (session != null && session.getAttribute("user") != null) {
            // Получаем объект пользователя из сессии

            User user = (User) session.getAttribute("user");

            // Проверяем, является ли пользователь администратором
            if (user.getRole().equalsIgnoreCase("admin")) {

                Collection<User> users = UserManager.getAllUsers();
                Collection<User> admins = new ArrayList<>();
                for(User u : users){
                    System.out.println(u.getName() + " " + u.getRole());
                    if(!u.getRole().equalsIgnoreCase("user") && !u.getRole().equalsIgnoreCase("muted")){
                        admins.add(u);
                    }
                }
                List<User> muted = new ArrayList<>();
                for (User u : users) {
                    if (u.getRole().equalsIgnoreCase("muted") && !admins.contains(u)) {
                        muted.add(u);
                    }
                }
                for (User admin : admins) {
                    System.out.println("ID: " + admin.getId() + ", Name: " + admin.getName() + ", Role: " + admin.getRole());
                }
                request.setAttribute("muted", muted);
                request.setAttribute("admins", admins);

                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminlist.jsp");
                dispatcher.forward(request, response);
            }    else {
                // Если пользователь не является администратором, перенаправляем его
                RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=go_to_index_page&authError=You are not authorized to access this page.");
                dispatcher.forward(request, response);
            }
        } else {
            // Если пользователь не авторизован, перенаправляем его
            RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=go_to_index_page&authError=You cannot perform this action. Please log in!");
            dispatcher.forward(request, response);
        }
    }
}
