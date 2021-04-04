<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.text"/>
<html>
<body>
<form action="${pageContext.request.contextPath}/main-controller" method="post">
    <input type="hidden" name="command" value="sign_up">
    <input type="text" id="email" name="email" placeholder="Электронная почта" value="${email}"
    required pattern="^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\.[a-zA-Z]{2,4}">
    <c:if test="${errorEmailMessageInvalid}">
        <div class="alert alert-danger" role="alert">
            "Электронная почта неверна"
        </div>
    </c:if>
    <c:if test="${errorEmailMessageIsExist}">
        <div class="alert alert-danger" role="alert">
            "Электронная почта уже существует"
        </div>
    </c:if>
    <input type="text" id="name" name="name" value="${name}" placeholder="name" required>
    <input type="text" id="surname" name="surname" value="${surname}" placeholder="surname" required>
    <c:if test="${errorNameAndSurnameMessage}">
        <div class="alert alert-danger" role="alert">
            "Неверный имя или пароль"
        </div>
    </c:if>
    <input type="password" id="password" name="password" placeholder="password" required
           pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"
           title='input.title.password'>
    <input type="password" id="repeat_password" name="repeat_password" placeholder="passwordRepeat" required
           pattern="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"
           title='password'>
    <c:if test="${errorPasswordMessage}">
        <div class="alert alert-danger" role="alert">
            "Неверный имя или пароль"
        </div>
    </c:if>
    <input type="submit" value="register">
</form>

<form action="${pageContext.request.contextPath}/main-controller" method="get">
    <input type="hidden" name="command" value="login">
    <input type="submit" value="signIn">
</form>
<form action="${pageContext.request.contextPath}/main-controller" method="get">
    <input type="hidden" name="command" value="index">
    <input type="submit" value="Главная страница">
</form>
</body>
</html>