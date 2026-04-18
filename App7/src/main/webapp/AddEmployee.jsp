<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
<center>
<%
String Data=(String)request.getAttribute("msg");
out.println(Data+ "<br><br>");
%>

<a href="Addemp.html">add employee details</a><br><br>

<a href="view">view employee details</a>

</center></h1>

</body>
</html>