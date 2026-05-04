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


String UserName=(String)request.getParameter("uname");
String msg1=(String)application.getAttribute("msg1");
String msg2=(String)application.getAttribute("msg2");

out.println("Username :"+Username+"<br><br>");
out.println("servletContext data :"+msg1+"<br><br>");
out.println("servletContext data :"+msg2+"<br><br>");
out.println("server name :"+application.getServerInfo()+"<br><br>");
out.println("servletConfig Data :"+msg3+"<br><br>");




%></h1>

</body>
</html>