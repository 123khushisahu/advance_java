<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.bean.UserBean" %>
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
String fname=(String)request.getAttribute("fname");
UserBean ub=(UserBean)application.getAttribute("ubean");
out.println("This session belong to:"+fname+"<br><br>");
out.println("<u>profile details</u><br><br>");
String pwd=ub.getU_pwd();
pwd.substring(0, 1).concat("***********").concat(pwd.substring(pwd.length()-1));
out.println(ub.getU_name()+" "+ub.getU_pwd()+" "+ub.getU_fname()+" "+ub.getU_lname()+" "+ub.getU_mailid()+" "+ub.getU_phn()+"<br><br>");

%>
<a href="edit">edit profile</a><br><br>
<a href="logout">Logout</a><br><br>
</h1></center>
</body>
</html>