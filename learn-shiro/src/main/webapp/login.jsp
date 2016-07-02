<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <style>.error {
        color: red;
    }</style>
</head>
<body>
<h1>login page</h1>
<div class="error">${message}</div>
<form action="" method="post">
    用户名：<input type="text" name="userId" value="<shiro:principal/>"><br/>
    密码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>