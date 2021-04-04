<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sorted list</title>
</head>
<body>
<h1>Sorted user list by id</h1>
<div>
    <table>
        <c:forEach var="elem" items="${list}" varStatus="status">
            <tr>
                <td><c:out value="${elem}"/>></td>
                <td><c:out value="${elem.userId}"/>></td>
                <td><c:out value="${elem.username}"/>></td>
                <td><c:out value="${elem.password}"/>></td>
                <td><c:out value="${elem.email}"/>></td>
                <td><c:out value="${elem.phone}"/>></td>
                <td><c:out value="${elem.averageRating}"/>></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>