<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>

<body>

<center>
<h1>

<%
pageContext.setAttribute("fname","java is awesome");
%>

<c:set var="name" value="${param.uname}" />

Welcome :
<c:out value="${name}" />
<br><br>

<c:set var="a" value="${applicationScope.a}" />
<c:set var="b" value="${sessionScope.b}" />
<c:set var="c" value="${requestScope.c}" />
<c:set var="d" value="${pageScope.fname}" />

Application Scope :
<c:out value="${a}" />
<br>

Session Scope :
<c:out value="${b}" />
<br>

Request Scope :
<c:out value="${c}" />
<br>

Page Scope :
<c:out value="${d}" />
<br>

</h1>
</center>

</body>
</html>