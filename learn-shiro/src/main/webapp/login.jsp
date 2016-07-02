<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
</head>
<body>
<h1>login page</h1>
<form id="" action="${ctx}/auth/login" method="post">
    <label>User Name</label>
    <input type="text" name="userId" maxLength="40">
    <label>Password</label>
    <input type="password" name="password">
    <input type="submit" value="login">
</form>
<%--用于输入后台返回的验证错误信息 --%>
<p><c:out value="${message }" /></p>
</body>
</html>