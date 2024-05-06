package controllers.concrete.impl;

import java.io.IOException;

import bean.News;
import controllers.concrete.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsManager;

public class newsAdd implements Command {

	    @Override
	    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			long id = NewsManager.getAllNews().size();
	        String title = request.getParameter("title");
	        String brief = request.getParameter("brief");
	        String info = request.getParameter("info");
	        String imagePath = request.getParameter("image");

	        // Создаем экземпляр News с полученными данными
	        News news = new News(id, title, brief, info, imagePath, null);
	        // Добавляем новость в сервис
			NewsManager.addNews(news);

	        // Перенаправляем на страницу с новостями после успешного добавления
	        response.sendRedirect("MyController?command=go_to_main_page");
	    }
}
