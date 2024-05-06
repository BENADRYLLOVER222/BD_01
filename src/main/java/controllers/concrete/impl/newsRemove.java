package controllers.concrete.impl;

import controllers.concrete.Command;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsManager;

import java.io.IOException;

public class newsRemove implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("newsId"));
        NewsManager.removeNews(id);
        response.sendRedirect("MyController?command=go_to_main_page");
    }

}
