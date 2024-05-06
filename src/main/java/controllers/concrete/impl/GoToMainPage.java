package controllers.concrete.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import bean.News;
import controllers.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.InfoService;
import service.NewsManager;
import service.ServiceProvider;

public class GoToMainPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if(session != null && session.getAttribute("user") != null) {
			Collection<News> mainNews = NewsManager.getAllNews();
			request.setAttribute("mainNews", mainNews);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/news.jsp");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("MyController?command=go_to_index_page&authError=You cannot perform this action. Please log in!");
		}
	}
}
