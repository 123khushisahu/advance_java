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
String msg2=(String)application.getInitParameter("msg2");
String ServletName=(String)request.getAttribute("ServletName");
String msg3=(String)request.getAttribute("msg3");


out.println("User name :"+UserName+"<br><br>");
out.println("ServletContext data :"+msg1+"<br><br>");
out.println("ServletContext data:"+msg2+"<br><br>");
out.println("Server name :"+application.getServerInfo()+"<br><br>");
out.println("ServletName :"+ServletName+"<br><br>");
out.println("ServletConfig data : "+msg3+"<br><br>");

%>
</h1></center>

</body>
</html>