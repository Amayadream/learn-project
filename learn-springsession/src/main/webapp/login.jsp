<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset=utf-8">
    <title>Login Page</title>
</head>
<body>
<h1>login page</h1>
<form id="" action="${ctx}/auth/check" method="post">
    <label for="userid">User Name</label>
    <input type="text" id="userid" name="userid" maxLength="40" />
    <label for="password">Password</label>
    <input type="password" id="password" name="password" />
    <input type="submit" value="login" />
</form>
<%--用于输入后台返回的验证错误信息 --%>
<P><c:out value="${error }" /></P>
</body>
</html>