package controllers;

import bean.News;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Long.parseLong;


@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получаем идентификатор новости из параметра запроса "id"
        String newsId = request.getParameter("id");

        // Реализуйте логику получения новости по ее идентификатору
        News news = NewsManager.getNewsById(parseLong(newsId));
        Collection<News> allNews = NewsManager.getAllNews();
        List<News> lastThreeNews = new ArrayList<>();
        List<News> allNewsList = new ArrayList<>(allNews);
// Проверяем, достаточно ли новостей в списке.
        int size = allNewsList.size();
        int newsCount = Math.min(3, size); // Берем минимум из трех и количества новостей в списке.
// Получаем последние три новости.
        for (int i = 0; i < newsCount; i++) {
            lastThreeNews.add(allNewsList.get(size - 1 - i));
        }
        if (news != null) {
            // Устанавливаем новость как атрибут в запросе
            request.setAttribute("three_news", lastThreeNews);
            request.setAttribute("news_s", news);

            // Перенаправляем запрос на JSP-страницу с деталями о новости
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/news-details.jsp");
            dispatcher.forward(request, response);
        } else {
            // Обработка случая, когда новость не найдена
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "News not found");
        }
    }
}