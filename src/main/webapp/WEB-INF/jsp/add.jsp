<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>News Page</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/add.css">
</head>

<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- End header -->

<!-- PAGE CONTENT START -->
<div class="page-content">
    <div class="logo-mobile">
        <img src="https://i.ibb.co/18QBf0h/logo.png" alt="logo">
    </div>

<!---------------------------------------------------------PAGE CONTENT START-------------------------------------------------->
<form action="MyController" method="post">
 <input type="hidden" name="command" value="news_add"/>
    <input type="text" name="title" placeholder="Title">
    <input type="text" name="brief" placeholder="Brief">
    <input type="text" name="info" placeholder="Info">
    <input type="text" name="image" placeholder="Image link">
    <textarea name="full_text" placeholder="Full text"></textarea>
    <button type="submit">ADD NEWS</button>
</form>
<!----------------------FOOTER---------------------->
    <div class="company">
        <img src="https://i.ibb.co/bLSdcL1/company.png" alt="company">
    </div>

    <!-- Begin footer -->
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
    <!-- End footer -->


</div>
<!---------------------------------------------------------SCRIPTS-------------------------------------------------->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/menu.js"></script>
</body>

</html>