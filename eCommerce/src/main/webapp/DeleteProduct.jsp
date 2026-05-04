<%@ page import="com.bean.AdminBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>

<style>

body{
	margin:0;
	padding:0;
	font-family:Arial;
	background:linear-gradient(135deg,#0f172a,#1e3a8a,#2563eb);
	height:100vh;
	display:flex;
	justify-content:center;
	align-items:center;
}

.box{
	width:500px;
	padding:40px;
	background:rgba(255,255,255,0.12);
	backdrop-filter:blur(10px);
	border-radius:20px;
	text-align:center;
	box-shadow:0px 8px 25px rgba(0,0,0,0.4);
}

h1{
	color:white;
	font-size:35px;
}

a{
	text-decoration:none;
	color:white;
	background:black;
	padding:12px 25px;
	margin:10px;
	border-radius:10px;
	display:inline-block;
	font-size:20px;
	transition:0.3s;
}

a:hover{
	background:red;
	transform:scale(1.05);
}

.msg{
	color:yellow;
	font-size:22px;
	margin:20px 0;
}

</style>

</head>
<body>

<div class="box">

<h1>

<%
AdminBean abean=(AdminBean)session.getAttribute("AdminBean");

String data=(String)request.getAttribute("msg");

out.println("Hello " + abean.getA_fname());
%>

</h1>

<div class="msg">
<%
if(data!=null)
{
	out.println(data);
}
%>
</div>

<a href="AddProduct.html">Add Product</a>

<a href="view1">View Product</a>

<a href="Logout">Logout</a>

</div>

</body>
</html>