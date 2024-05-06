<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
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

.error-message{
color:red;
display:flex;
margin-left: 0;
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

    <div class = "cintainer mt-5">
       <form class ="form-signin" action = "MyController" method="post"> 
            <input type="hidden" name="command" value="do_auth"/>
        <div class="regfield">
        

			<div class="error-message" id="error-message">
                <c:if test="${not (param.authError eq null)}">
                    <c:if test="${param.authError eq 'You have successfully registered!'}">
                         <span style="color: green;">
                            <c:out value="${param.authError}" />
                         </span>
                    </c:if>
                        <c:if test="${param.authError ne 'You have successfully registered!'}">
                        <c:out value="${param.authError}" />
                    </c:if>
                </c:if>
			</div>

            <div class = "form-group">
            <div class="login">
                <input type="text" class="form-control" id="loginUsername" name="login"  placeholder="Login" required>
            </div>
        </div>
            <div class="form-group">
            <div class="password">
                <input type="password" class="form-control" id="loginPassword" name="password" placeholder="Password" required>
            </div>
        </div>
            <div class="regbutton">
                <input type="submit" class = "btn btn-primary" value="Sign In">
            </div>
            <div class="registration">
                <p> <a href="MyController?command=go_to_registration_page">Registration</a></p>
            </div>
        </div>
        </form>

     </div>
    <!-- Подвал страницы -->
    <footer>
    </footer>
</body>
</html>