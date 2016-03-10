<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset=utf-8">
    <title>index</title>
</head>
<body>
<%
    //将javabean对象绑定到Session中
    session.setAttribute("bean","asdasd");
    //从Session中删除javabean对象
    session.removeAttribute("bean");
%>
<c:if test="${userid!=null}">
    Welcome, ${userid}
</c:if>

<c:out value="${message}"/>
</body>
</html>