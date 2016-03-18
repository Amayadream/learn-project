<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login</title>
    <style>.message{color: red}</style>
</head>
<body>
    <form action="" method="post">
        <label for="userid">用户名:</label>
        <input type="text" id="userid" name="userid" value="<shiro:principal/>">
        <label for="password">密码</label>
        <input type="password" id="password" name="password">
        自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
        <input type="submit" value="Submit">
    </form>
    <div class="message">${message}</div>
</body>
</html>
