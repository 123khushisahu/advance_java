<%@page import="com.bean.ProductBean" %>
<%@page import="com.bean.AdminBean" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Portal</title>

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
	background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);
	overflow:hidden;
	position:relative;
}

/* Animated Background */

body::before{
	content:'';
	position:absolute;
	width:420px;
	height:420px;
	background:rgba(0,255,255,0.08);
	border-radius:50%;
	top:-120px;
	left:-120px;
	filter:blur(5px);
	animation:move1 8s infinite alternate;
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
	animation:move2 8s infinite alternate;
}

/* Main Card */

center{
	width:480px;
	padding:45px;
	border-radius:28px;
	background:rgba(255,255,255,0.12);
	backdrop-filter:blur(14px);
	box-shadow:
	0 8px 32px rgba(0,0,0,0.4),
	0 0 20px rgba(0,247,255,0.15);
	border:1px solid rgba(255,255,255,0.18);
	position:relative;
	z-index:1;
	animation:fadeIn 1s ease;
}

/* Heading */

h1{
	color:white;
	font-size:38px;
	text-align:center;
	line-height:1.8;
	font-weight:700;
	letter-spacing:1px;
}

/* Stylish Underline */

u{
	text-decoration:none;
	position:relative;
}

u::after{
	content:'';
	position:absolute;
	width:100%;
	height:4px;
	left:0;
	bottom:-8px;
	background:linear-gradient(to right,#00f7ff,#00ff88);
	border-radius:20px;
}

/* Greeting Text */

.greet{
	font-size:20px;
	color:#f5f5f5;
	font-weight:500;
	display:block;
	margin-top:12px;
	margin-bottom:18px;
	text-shadow:0 0 10px rgba(255,255,255,0.3);
}

/* Labels */

form{
	margin-top:15px;
	text-align:left;
	color:white;
	font-size:17px;
	font-weight:600;
}

/* Input Fields */

input[type="text"]{
	width:100%;
	padding:15px;
	margin-top:10px;
	margin-bottom:22px;
	border:none;
	outline:none;
	border-radius:14px;
	font-size:16px;
	color:white;
	background:rgba(255,255,255,0.12);
	border:1px solid rgba(255,255,255,0.18);
	box-shadow:inset 0 0 10px rgba(255,255,255,0.05);
	transition:0.4s;
}

/* Focus Effect */

input[type="text"]:focus{
	border-color:#00f7ff;
	box-shadow:
	0 0 15px rgba(0,247,255,0.6),
	inset 0 0 8px rgba(255,255,255,0.1);
	transform:scale(1.02);
}

/* Button */

button{
	width:100%;
	padding:15px;
	border:none;
	border-radius:14px;
	font-size:19px;
	font-weight:bold;
	letter-spacing:1px;
	cursor:pointer;
	color:white;
	background:linear-gradient(45deg,#00c853,#00e676);
	box-shadow:0 5px 18px rgba(0,0,0,0.35);
	transition:0.4s;
	margin-top:10px;
}

/* Button Hover */

button:hover{
	transform:translateY(-5px) scale(1.02);
	box-shadow:
	0 10px 25px rgba(0,0,0,0.45),
	0 0 15px rgba(0,255,150,0.5);
	background:linear-gradient(45deg,#00e676,#76ff03);
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

@keyframes move1{
	from{
		transform:translateY(0px);
	}
	to{
		transform:translateY(30px);
	}
}

@keyframes move2{
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
<u>Edit Portal</u><br>

<%
AdminBean abean=(AdminBean)session.getAttribute("AdminBean");
ProductBean pb=(ProductBean)request.getAttribute("pbean");
out.println("<span class='greet'>✨ Hello "
+abean.getA_fname()+" Please Edit ✨</span>");
%>

<form action="update" method="post">

Product Price
<input type="text" name="p_price"
value="<%=pb.getPRICE()%>"><br>

Product Quantity
<input type="text" name="p_qty"
value="<%=pb.getPQTY()%>"><br>

<input type="hidden" name="p_code"
value="<%=pb.getPCODE()%>">

<button>🚀 Update Product</button>

</form>

</h1>

</center>

</body>
</html>