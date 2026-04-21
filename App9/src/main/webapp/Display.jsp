<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
0<h1>
<center>
<%
String pro_name=request.getParameter("pname");
String pro_id=request.getParameter("pid");
String pro_price=request.getParameter("pprice");
String pro_qty=request.getParameter("pqty");

out.println("**********product details**********" + "<br><br>");

out.println("product name:"+pro_name+ "<br><br>");
out.println("product id:"+pro_id + "<br><br>");
out.println("product price:"+pro_price + "<br><br>");
out.println("product qty:"+pro_qty + "<br><br>");

%>
</center>
</h1>
</body>
</html>