<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/registration.css">
    <title>Заголовок вашей страницы</title>
    <style>
html, body {
    height: 100%;
    margin: 0;
    display: flex;
    flex-direction: column;
    justify-content: center; /* Центрируем по горизонтали */
    align-items: center; /* Центрируем по вертикали */
    background-color: #f2f2f2;
}


.regfield {
    width: 300px;
    text-align: center;
}

.regfield input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    margin-bottom: 10px;
}



.btn-primary {
    background-color: black; /* Черный цвет фона */
    color: white; /* Белый цвет текста */
    transition: background-color 0.3s ease; /* Анимация при изменении цвета фона */
}

.btn-primary:hover {
    background-color: #333; /* Цвет фона при наведении */
}

.registration p {
    text-align: left;
    margin-top: 0;
}

.registration a {
    color: rgba(0, 0, 0, 0.5); /* Полупрозрачный цвет */
    text-decoration: none; /* Убираем подчеркивание */
    transition: color 0.3s; /* Плавное изменение цвета при наведении */
}

.registration a:hover {
    color: rgba(0, 0, 0, 0.7); /* Изменение цвета при наведении */
}</style>
</head>

<body>
    <!-- Шапка страницы -->
    <header>
        <h1>$$$</h1>
    </header>
    <form action="MyController" method="post">
        <input type="hidden" name="command" value="do_registration"/>
        <section>
            <div class="regfield">
                <c:if test="${not (param.error eq null) }">
                    <span style="color: red;"><c:out value="${param.error}" /></span>

                </c:if>
                <div class="form-group">
                    <input type="text" class="form-control" id="login" name="login" placeholder="Login" required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Registration">
                </div>
                <div class="form-group">
                    <p class="registration"> <a href="MyController?command=go_to_index_page">Login</a></p>
                </div>
            </div>
        </section>
    </form>
    <!-- Подвал страницы -->
    <footer>
    </footer>
</body>
</html>