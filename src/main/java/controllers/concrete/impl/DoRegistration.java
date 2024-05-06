package controllers.concrete.impl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.RegInfo;
import bean.User;
import bean.UserRegInfo;
import controllers.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserManager;
import service.UserService;
import service.impl.UserServiceImpl;

public class DoRegistration implements Command {
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Получаем логин и пароль из запроса
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// Проверяем, переданы ли логин и пароль
		if (login == null || password == null) {
			response.sendRedirect("MyController?command=go_to_registration_page&error=Login and password are required");
			return;
		}

		// Создаем объект UserRegInfo
		RegInfo regInfo = new RegInfo(login, password);

		// Вызываем метод регистрации из UserManager
		boolean registrationSuccess = userServiceImpl.registration(regInfo);

		// Проверяем, успешна ли регистрация
		if (registrationSuccess) {
			// Если регистрация прошла успешно, перенаправляем на страницу подтверждения регистрации
			response.sendRedirect("MyController?command=go_to_index_page&error=You have successfully registered!");
		} else {
			// Если произошла ошибка во время регистрации, перенаправляем на страницу ошибки
			response.sendRedirect("MyController?command=go_to_registration_page&error=An error occurred during registration or user already exists.");
		}
	}
}