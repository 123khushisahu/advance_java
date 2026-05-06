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
String username=request.getParameter("uname");
String FilterName=(String)request.getAttribute("fcobj");
String msg=(String)request.getAttribute("msg");


out.println("UserName :"+username+"<br><br>");
out.println("FilterName :"+FilterName+"<br><br>");
out.println("UserName :"+msg+"<br><br>");



%>
</h1>

</body>
</html>