
<%@page import="com.pack1.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
UserBean ub=(UserBean)request.getAttribute("userbean");
String pwd=ub.getU_pwd();
String con_pwd=pwd.substring(0,1)+"****"+pwd.substring(pwd.length()-2);
out.println("USERNAME"+ub.getU_uname()+"<br><br>");
out.println("PASSWORD"+con_pwd+"<br><br>");
out.println("FIRSTNAME"+ub.getU_fname()+"<br><br>");
out.println("LASTNAME"+ub.getU_lname()+"<br><br>");
out.println("MAIL ID"+ub.getU_mailid()+"<br><br>");
out.println("PHONE"+ub.getU_phone()+"<br><br>");
%>

</h1>

</body>
</html>