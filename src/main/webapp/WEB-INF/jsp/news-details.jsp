<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>News Page</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/detailednews.css">
</head>

<body>
<!-- Begin header -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- End header -->

<!-- Begin page content -->
<div class="page-content">
    <!-- Begin logo -->
    <div class="logo-mobile">
        <img src="https://i.ibb.co/18QBf0h/logo.png" alt="logo">
    </div>
    <!-- End logo -->

    <!-- Begin container -->
    <div class="container">
        <!-- Основной контент -->
        <div class="post">
            <div class="image">
                <img src="${news_s.imgPath}" alt="${news_s.title}">
            </div>
            <div class="text-part">
                <h1><c:out value="${news_s.title}" /></h1>
                <p><c:out value="${news_s.brief}" /></p>
                <p><c:out value="${news_s.info}" /></p>
            </div>
            </div>
            <div class="postButton">
                <form action="MyController" method="post">
                    <input type="hidden" name="command" value="news_remove"/>
                    <input type="hidden" name="newsId" value="${news_s.id}"/>
                    <button type="submit" class="delete">DELETE</button>
                </form>
            </div>


        <!-- Сайдбар -->
        <div class="sidebar">
            <h2>Latest News</h2>
            <c:forEach var="news" items="${three_news}">
                <div class="latest-news">
                    <h3><a href="<%= request.getContextPath() %>/news?id=${news.id}">${news.title}</a></h3>
                    <div class = "sideImg">
                    <img src = "${news.imgPath}" alt = ${news.title}>
                    </div>
                    <p><c:out value="${news.brief}" /></p>
                </div>
            </c:forEach>
        </div>
    </div>
<!-- End page content -->

<!-- Begin footer -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<!-- End footer -->

<!-- Begin scripts -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/menu.js"></script>
<!-- End scripts -->
</body>

</html>