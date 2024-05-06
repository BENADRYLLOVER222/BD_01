package controllers.concrete.impl;

import java.io.IOException;
import java.util.List;

import bean.News;
import controllers.concrete.Command;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.InfoService;
import service.ServiceProvider;

public class GoToRegistrationPage implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/reg.jsp");
		dispatcher.forward(request, response);
		
	}

}
