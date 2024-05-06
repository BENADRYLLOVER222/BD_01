package controllers.concrete.impl;

import java.io.IOException;
import java.util.Collection;

import bean.AuthInfo;
import bean.User;
import controllers.concrete.Command;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ServiceProvider;
import service.UserManager;
import service.UserService;

public class DoAuth implements Command{
	private final UserService userService = ServiceProvider.getInstance().getUserService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		
		System.out.println("Perform user authentication and authorization. Login: " + login);
		User user = userService.signIn(new AuthInfo(login, password));
		
		if(user != null) {
			HttpSession session = (HttpSession) request.getSession(true);
			session.setAttribute("user", user);
			
			response.sendRedirect("MyController?command=go_to_main_page");
			
		}else {
			
			response.sendRedirect("MyController?command=go_to_index_page&authError=Wrong login or password!");
			
			//response.sendError(500, "Неправильный логин или пароль!");
		}
		
	}

}
