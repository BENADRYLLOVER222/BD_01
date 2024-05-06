package service.impl;

import bean.*;
import jakarta.servlet.RequestDispatcher;
import service.UserManager;
import service.UserService;

import java.sql.*;
import java.util.Collection;
import java.util.Objects;

import static service.UserManager.*;

public class UserServiceImpl implements UserService {
	
	@Override
	public User signIn(AuthInfo authInfo) {
		Collection<User> users = UserManager.getAllUsers();
		for (User user : users) {
			if (Objects.equals(user.getName(), authInfo.getLogin()) && user.getPassword().equals(authInfo.getPassword())){
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean registration(RegInfo regInfo) {
		// Получаем логин и пароль из regInfo
		String login = regInfo.getUsername();
		String password = regInfo.getPassword();

		// Проверка существования пользователя с таким именем
		User existingUser = getUserByUsername(login);
		if (existingUser != null) {
			return false; // Пользователь уже существует
		}

		// Подключаемся к базе данных с использованием try-with-resources
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_database", "postgres", "6666")) {
			// Подготовленный запрос для вставки нового пользователя
			String sqlInsert = "INSERT INTO users_table (name, password, role) VALUES (?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
				// Устанавливаем параметры запроса
				pstmt.setString(1, login);
				pstmt.setString(2, password);
				pstmt.setString(3, "user"); // Роль по умолчанию

				// Выполняем запрос
				pstmt.executeUpdate();
			}

			// Обновляем список пользователей
			UserManager.refreshUserList();

			// Регистрация прошла успешно
			return true;

		} catch (SQLException e) {
			// Обработка исключений
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean blockUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Profile userProfile(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
