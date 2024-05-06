<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* Центрирование содержимого страницы */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* Высота страницы - 100% высоты окна браузера */
        margin: 0;
    }

    /* Стили для контейнера */
    .welcome-page-content {
        text-align: center; /* Центрируем содержимое по горизонтали */
    }

    /* Стили для черной кнопки */
    .btn-primary {
        background-color: black; /* Черный цвет фона */
        color: white; /* Белый цвет текста */
        padding: 10px 20px;
        border: none;
        cursor: pointer;
    }
    
    .btn-primary:hover {
        background-color: #242424; /* Цвет фона при наведении */
    }
    
    /* Стили для новостей */
    .news {
        margin-top: 30px;
    }
</style>
</head>
<body>
<div class="welcome-page-content">
    <div class="form-group">
        <button type="button" class="btn-primary" onclick="window.location.href='MyController?command=go_to_index_page'">
            GO TO LOGIN PAGE
        </button>
    </div>
</div>
</body>
</html>