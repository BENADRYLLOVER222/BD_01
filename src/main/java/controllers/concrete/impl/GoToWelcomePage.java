package controllers.concrete.impl;

import java.io.IOException;

import bean.News;
import controllers.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToWelcomePage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/welcome_page.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
