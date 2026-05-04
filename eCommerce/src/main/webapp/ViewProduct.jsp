<%@ page import="java.util.*, com.bean.AdminBean" %>
<%@ page import="java.util.*, com.bean.ProductBean" %>


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
	background:linear-gradient(135deg,#141e30,#243b55);
	min-height:100vh;
	display:flex;
	justify-content:center;
	align-items:center;
	padding:40px;
	position:relative;
	overflow:auto;
}

/* Background Decoration */

body::before{
	content:'';
	position:absolute;
	width:350px;
	height:350px;
	background:rgba(255,255,255,0.05);
	border-radius:50%;
	top:-100px;
	left:-100px;
}

body::after{
	content:'';
	position:absolute;
	width:300px;
	height:300px;
	background:rgba(255,255,255,0.05);
	border-radius:50%;
	bottom:-100px;
	right:-100px;
}

/* Main Card */

center{
	width:95%;
	max-width:1100px;
	background:rgba(255,255,255,0.1);
	padding:40px;
	border-radius:25px;
	backdrop-filter:blur(10px);
	box-shadow:0 8px 32px rgba(0,0,0,0.35);
	border:1px solid rgba(255,255,255,0.15);
	position:relative;
	z-index:1;
	animation:fadeIn 1s ease;
}

/* Heading */

h1{
	color:white;
	font-size:38px;
	line-height:2;
	text-align:center;
}

u{
	text-decoration:none;
	position:relative;
}

u::after{
	content:'';
	position:absolute;
	width:100%;
	height:4px;
	background:#00f7ff;
	left:0;
	bottom:-8px;
	border-radius:10px;
}

/* Product Data Style */

h1 br{
	line-height:20px;
}

/* Links */

a{
	text-decoration:none;
	padding:10px 18px;
	border-radius:10px;
	font-size:15px;
	font-weight:bold;
	color:white;
	display:inline-block;
	margin:5px;
	transition:0.3s;
	box-shadow:0 5px 15px rgba(0,0,0,0.3);
}

/* Edit Button */

a[href*="edit"]{
	background:linear-gradient(45deg,#2979ff,#00b0ff);
}

/* Delete Button */

a[href*="delete"]{
	background:linear-gradient(45deg,#ff1744,#ff5252);
}

/* Hover Effect */

a:hover{
	transform:translateY(-3px) scale(1.05);
	box-shadow:0 8px 20px rgba(0,0,0,0.45);
}

/* Product Text */

h1{
	word-spacing:6px;
	letter-spacing:0.5px;
}

/* Animation */

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

</style>

</head>
<body>

<center>
<h1><u>Product data</u><br><br>

<%
AdminBean abean=(AdminBean)session.getAttribute("AdminBean");
ArrayList<ProductBean> a1=(ArrayList<ProductBean>)session.getAttribute("ProductList");

if(a1.size()==0)
	out.println("❌ Product data not available!!!");
else
{
	Iterator<ProductBean> i=a1.iterator();
	while(i.hasNext())
	{
		ProductBean pb=i.next();
		out.println(
		"✨ "+pb.getPCODE()+" | "
		+pb.getPNAME()+" | "
		+pb.getPCOMPANY()+" | ₹"
		+pb.getPRICE()+" | Qty : "
		+pb.getPQTY()+" "
		+"<a href='edit?pcode="+pb.getPCODE()+"'>EDIT</a>"+" "
		+"<a href='delete?pcode="+pb.getPCODE()+"'>DELETE</a>"+" "
		+"<br><br>");
	}
}

%>

</h1>

</center>

</body>
</html>