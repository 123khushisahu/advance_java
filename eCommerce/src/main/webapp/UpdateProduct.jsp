<%@ page import="com.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:'Poppins',sans-serif;
}

body{
	height:100vh;
	display:flex;
	justify-content:center;
	align-items:center;
	background:linear-gradient(135deg,#0f172a,#1e293b,#0f766e);
	overflow:hidden;
	position:relative;
}

/* Background Glow */

body::before{
	content:'';
	position:absolute;
	width:450px;
	height:450px;
	background:rgba(0,255,255,0.08);
	border-radius:50%;
	top:-150px;
	left:-150px;
	filter:blur(10px);
	animation:float1 6s infinite alternate;
}

body::after{
	content:'';
	position:absolute;
	width:350px;
	height:350px;
	background:rgba(255,255,255,0.06);
	border-radius:50%;
	bottom:-120px;
	right:-120px;
	filter:blur(10px);
	animation:float2 6s infinite alternate;
}

/* Main Glass Card */

center{
	width:520px;
	padding:55px;
	border-radius:30px;
	background:rgba(255,255,255,0.12);
	backdrop-filter:blur(18px);
	box-shadow:
	0 10px 40px rgba(0,0,0,0.5),
	0 0 25px rgba(0,255,255,0.15);
	border:1px solid rgba(255,255,255,0.2);
	position:relative;
	z-index:1;
	animation:fadeIn 1s ease;
}

/* Heading */

h1{
	color:white;
	font-size:34px;
	text-align:center;
	line-height:2;
	letter-spacing:1px;
}

/* Welcome Text */

.msg{
	display:block;
	font-size:25px;
	font-weight:700;
	color:#00f7ff;
	text-shadow:0 0 15px rgba(0,247,255,0.5);
	margin-bottom:10px;
}

/* Data Message */

.data{
	display:block;
	font-size:20px;
	color:#f8fafc;
	margin-bottom:25px;
	text-shadow:0 0 10px rgba(255,255,255,0.2);
}

/* Buttons */

a{
	display:inline-block;
	text-decoration:none;
	padding:15px 28px;
	margin:12px;
	border-radius:14px;
	color:white;
	font-size:17px;
	font-weight:bold;
	letter-spacing:1px;
	transition:0.4s;
	box-shadow:0 5px 18px rgba(0,0,0,0.35);
	position:relative;
	overflow:hidden;
}

/* Individual Colors */

a:nth-of-type(1){
	background:linear-gradient(45deg,#00c853,#64dd17);
}

a:nth-of-type(2){
	background:linear-gradient(45deg,#2979ff,#00b0ff);
}

a:nth-of-type(3){
	background:linear-gradient(45deg,#ff1744,#ff5252);
}

/* Hover Effect */

a:hover{
	transform:translateY(-5px) scale(1.05);
	box-shadow:
	0 10px 25px rgba(0,0,0,0.45),
	0 0 15px rgba(255,255,255,0.2);
}

/* Shine Animation */

a::before{
	content:'';
	position:absolute;
	top:0;
	left:-100%;
	width:100%;
	height:100%;
	background:rgba(255,255,255,0.2);
	transform:skewX(-30deg);
	transition:0.6s;
}

a:hover::before{
	left:120%;
}

/* Animations */

@keyframes fadeIn{
	from{
		opacity:0;
		transform:translateY(40px);
	}
	to{
		opacity:1;
		transform:translateY(0);
	}
}

@keyframes float1{
	from{
		transform:translateY(0px);
	}
	to{
		transform:translateY(30px);
	}
}

@keyframes float2{
	from{
		transform:translateX(0px);
	}
	to{
		transform:translateX(-30px);
	}
}

</style>

</head>

<body>

<center>

<h1>

<%
AdminBean abean=(AdminBean)session.getAttribute("AdminBean");
String data=(String)request.getAttribute("msg");

out.println("<span class='msg'>✨ Hello "
+abean.getA_fname()+" ✨</span><br><br>");

out.println("<span class='data'>"+data+"</span><br><br>");
%>

<a href="AddProduct.html">➕ AddProduct</a>

<a href="view1">📦 View Product</a>

<a href="Logout">🚪 Logout</a>

</h1>

</center>

</body>
</html>