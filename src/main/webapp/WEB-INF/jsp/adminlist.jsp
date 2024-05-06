<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Пример HTML-страницы</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/admin-list.css">
    <link rel="stylesheet" href="styles/header.css">
    <script src="script.js"></script>
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
<div class="container">
    <!-- Панель привилегий -->
<div class = "admin-panel">
    <h1>PRIVILEGES PANEL</h1>
    <h4>Add new privileged user</h4>
    <div class="add-privileges">

            <c:if test="${not (param.priverror eq null)}">
            <span style="color: red;">
                <c:out value="${param.priverror}" />
             </span>
            </c:if>
        <form action="MyController" method="post">
            <input type="hidden" name="command" value="user_add_priv"/>
            <input type="text" id="muteuser" name="useraddpriv" placeholder="Username">
            <select id="role-change" name="role_add">
                <option value="admin" ${admin.role == 'admin' ? 'selected' : ''}>Admin</option>
                <option value="editor" ${admin.role == 'editor' ? 'selected' : ''}>Editor</option>
                <option value="moderator" ${admin.role == 'moderator' ? 'selected' : ''}>Moderator</option>
            </select>
            <button id="mute">ADD</button>
        </form>
    </div> <!-- add-privileges -->

    <h4>PRIVILEGED USERS LIST</h4>
    <div class="user-list">
        <form action="MyController" method="post">
            <input type="hidden" name="command" value="user_priv_change"/>
            <!-- Список пользователей с полями -->
            <c:forEach var="admin" items="${requestScope.admins}">
                <div class="line">
                    <input type="hidden" name="username_${admin.id}" value="${admin.name}" />
                    <div class="username">
                        <span>${admin.name}</span>
                    </div>
                    <div class="role">
                        <h5>${admin.role}</h5>
                    </div>
                    <select name="newRole_${admin.id}">
                        <option value="admin" ${admin.role == 'admin' ? 'selected' : ''}>Admin</option>
                        <option value="editor" ${admin.role == 'editor' ? 'selected' : ''}>Editor</option>
                        <option value="moderator" ${admin.role == 'moderator' ? 'selected' : ''}>Moderator</option>
                        <option value="user" ${admin.role == 'user' ? 'selected' : ''}>User</option>
                        <option value="muted" ${admin.role == 'muted' ? 'selected' : ''}>Mute</option>
                    </select>
                </div>
            </c:forEach>
            <div class = "commit-div">
            <button type="submit" id="commit">COMMIT CHANGES</button>
        </div>
        </form>
    </div> <!-- user-list -->
</div>
    <div class="blacklist">
        <h1>BLACKLIST</h1>
        <h4>Add user to the blacklist</h4>
        <form action="MyController" method="post">
            <input type="hidden" name="command" value="user_add_to_blacklist"/>
            <c:if test="${not (param.blackerror eq null)}">
            <span style="color: red;">
                <c:out value="${param.blackerror}" />
             </span>
            </c:if>
            <div class="addtoblack">
                <input id="muteuser" name="username" placeholder="Username">
                <button type="submit" id="mute">MUTE</button>
            </div> <!-- addtoblack -->
        </form>
        <div class="muted">
            <h4>BANNED USERS LIST</h4>
            <div class="listed">
                <form action="MyController" method="post" onsubmit="copySpanValue()">
                <c:forEach var="muted" items="${requestScope.muted}">
                    <input type="hidden" name="command" value="remove_user_from_blacklist"/>
                    <span id="mutedUser" name = "muted">${muted.name}</span>
                    <input type="hidden" name="mutedUserName" id="mutedUserName" />
                    <button type="submit" id="unban">UNBAN</button>
                </c:forEach>
                </form>
            </div> <!-- listed -->
        </div> <!-- muted -->
    </div> <!-- blacklist -->
</div> <!-- container -->

    <!-- Begin footer -->
    <jsp:include page="/WEB-INF/jsp/footer.jsp" />
    <!-- End footer -->

</div> <!-- page-content -->

<script> function copySpanValue() {
    // Получаем элемент span по идентификатору
    var spanElement = document.getElementById("mutedUser");
    // Получаем скрытое поле по идентификатору
    var hiddenInput = document.getElementById("mutedUserName");
    // Устанавливаем значение скрытого поля равным значению из span
    hiddenInput.value = spanElement.textContent;
}</script>
<script>function prepareFormData() {
    // Получаем элементы span и h5 по их идентификаторам
    var usernameElement = document.getElementById("username");
    var currentRoleElement = document.getElementById("currentRole");

    // Получаем скрытые поля для имени пользователя и текущей роли
    var hiddenUsername = document.getElementById("hiddenUsername");
    var hiddenCurrentRole = document.getElementById("hiddenCurrentRole");

    // Устанавливаем значения скрытых полей в значения из элементов span и h5
    hiddenUsername.value = usernameElement.textContent;
    hiddenCurrentRole.value = currentRoleElement.textContent;
}</script>
</body>
</html>