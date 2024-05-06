package controllers.concrete;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
	
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;

}
