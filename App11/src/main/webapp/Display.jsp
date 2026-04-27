
<%@ page import="java.util.Arrays" %>
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
<u>Data Form Html</u><br><br>
<%
String name=request.getParameter("tname");
String age=request.getParameter("tage");
String gender=request.getParameter("gen");
String addr=request.getParameter("taddress");
String MaritalStatus=request.getParameter("ms");
String Qualification=request.getParameter("qlfy");
String Courses=request.getParameter("crs");
String Hobbies[]=request.getParameterValues("hb");


out.println("Name :- "+name+"<br><br>");
out.println("Age :- "+age+"<br><br>");
out.println("Gender :- "+gender+"<br><br>");
out.println("Address :- "+addr+"<br><br>");
out.println("MaritalStatus :- "+MaritalStatus+"<br><br>");
out.println("Qualification :- "+Qualification+"<br><br>");
out.println("Courses :- "+Courses+"<br><br>");
out.println("Hobbies :- " +Arrays.toString(Hobbies)+"<br><br>");



%>
</h1>

</body>
</html>