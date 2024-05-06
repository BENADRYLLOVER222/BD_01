<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>News Page</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/news.css">
</head>

<body>
<!-- Begin header -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- End header -->

    <!-- PAGE CONTENT START -->
    <div class="page-content">
        <div class="logo-mobile">
            <img src="https://i.ibb.co/18QBf0h/logo.png" alt="logo">
        </div>

        <section class="cards">
            <div class="container container__cards">
                <c:forEach var="news" items="${requestScope.mainNews}">
                    <div class="card">
                        <div class="card__top">
                            <a href="<%= request.getContextPath() %>/news?id=${news.id}" class="card__img">
                                <img src="${news.imgPath}" alt="${news.title}">
                            </a>
                        </div>
                        <div class="card__bottom">
                            <div class="card__title" style="font-size: 24px;">
                                <a href="<%= request.getContextPath() %>/news?id=${news.id}">
                                    <span>${news.title}</span>
                                </a>
                            </div>
                            <div class="card__anons">
                                <a href="<%= request.getContextPath() %>/news?id=${news.id}">
                                    <span>${news.brief}</span>
                                </a>
                            </div>
                            <div class="readMore">
                                <a href="<%= request.getContextPath() %>/news?id=${news.id}">
                                    <button class="readMore">Читать далее...</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>
    <!-- PAGE CONTENT END -->

    <div class="company">
        <img src="https://i.ibb.co/bLSdcL1/company.png" alt="company">
    </div>

<!-- Begin footer -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<!-- End footer -->


    <!-- SCRIPTS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/menu.js"></script>
    <!-- END SCRIPTS -->
</body>

</html>