<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<%
UserBean bean=(UserBean)application.getAttribute("ubean");
out.println("Welcome mr."+bean.getU_fname()+"<br><br>");
%>
<a href="View">View Profile</a><br><br>
<a href="logout">Logout</a><br><br>
</h1>

</center>

</body>
</html>