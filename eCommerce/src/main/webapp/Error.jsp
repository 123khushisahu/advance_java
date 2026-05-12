<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>
<%
String msg=(String)request.getAttribute("msg");
response.sendError(HttpServletResponse.SC_ACCEPTED);
response.sendError(404,msg);


%>
<%=msg %>
<a href="AddProduct.html">AddProduct.html</a><br><br>
<a href="view1">View Product</a><br><br>
<a href="logout">Logout</a><br><br>
</h1>

</body>
</html>