package controllers;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import controllers.concrete.Command;
import controllers.concrete.CommandProvider;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        try {
            doRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        try {
            doRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String userCommand = request.getParameter("command");

		Command command = provider.takeCommand(userCommand);
		command.execute(request, response);
		
	}
}
