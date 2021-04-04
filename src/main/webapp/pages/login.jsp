<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="main-controller" method="get">
    <input type="hidden" name="command" value="login" />
    Login:<br/><input type="text" name="login" value=""/>
    <br/>Password:<br/><input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${errorMessage}
    <br/>
    <input type="submit" value="Log in"/>
</form><hr/>
</table>
</body>
</html>
