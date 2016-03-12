<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <c:if test="${userid != null}">
        <h1>Welcome, ${userid}, ${message}</h1>
    </c:if>
    <c:if test="${userid == null}">
        <h1>${message}</h1>
    </c:if>
</body>
</html>
