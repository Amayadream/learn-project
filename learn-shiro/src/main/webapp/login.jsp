<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="${ctx}/auth/login" method="post">
        <label for="userid">用户名:</label>
        <input type="text" id="userid" name="userid">
        <label for="password">密码</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Submit">
    </form>
    <c:if test="${message != null}">
        <b><font color="red">${message}</font></b>
    </c:if>
</body>
</html>
