<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>

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
	background:linear-gradient(135deg,#141e30,#243b55);
	overflow:hidden;
	position:relative;
}

/* Animated Background Circles */

body::before{
	content:'';
	position:absolute;
	width:350px;
	height:350px;
	background:rgba(255,255,255,0.08);
	border-radius:50%;
	top:-100px;
	left:-100px;
}

body::after{
	content:'';
	position:absolute;
	width:300px;
	height:300px;
	background:rgba(255,255,255,0.06);
	border-radius:50%;
	bottom:-80px;
	right:-80px;
}

/* Main Box */

.box{
	width:480px;
	padding:40px;
	border-radius:25px;
	background:rgba(255,255,255,0.12);
	backdrop-filter:blur(12px);
	box-shadow:0 8px 32px rgba(0,0,0,0.35);
	border:1px solid rgba(255,255,255,0.15);
	position:relative;
	z-index:1;
	animation:fadeIn 1s ease;
}

/* Heading */

h1{
	text-align:center;
	color:white;
	font-size:35px;
	margin-bottom:30px;
	letter-spacing:1px;
}

/* Underline */

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

/* Input Fields */

.input-box{
	margin-bottom:22px;
}

.input-box label{
	display:block;
	color:white;
	font-size:16px;
	font-weight:600;
	margin-bottom:8px;
	letter-spacing:0.5px;
}

.input-box input{
	width:100%;
	padding:14px;
	border:none;
	outline:none;
	border-radius:12px;
	font-size:15px;
	background:rgba(255,255,255,0.15);
	color:white;
	border:1px solid rgba(255,255,255,0.2);
	transition:0.4s;
}

/* Placeholder */

.input-box input::placeholder{
	color:#ddd;
}

/* Focus Effect */

.input-box input:focus{
	border-color:#00f7ff;
	box-shadow:0 0 12px rgba(0,247,255,0.6);
	transform:scale(1.02);
}

/* Button */

.btn{
	width:100%;
	padding:15px;
	border:none;
	border-radius:14px;
	background:linear-gradient(45deg,#00c853,#64dd17);
	color:white;
	font-size:18px;
	font-weight:bold;
	letter-spacing:1px;
	cursor:pointer;
	transition:0.4s;
	box-shadow:0 5px 15px rgba(0,0,0,0.3);
}

.btn:hover{
	transform:translateY(-4px);
	box-shadow:0 10px 20px rgba(0,0,0,0.45);
	background:linear-gradient(45deg,#00e676,#76ff03);
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

<div class="box">

<h1><u>Add Product</u></h1>

<form action="aps" method="post">

<div class="input-box">
<label>Product Code</label>
<input type="text" name="pcode" placeholder="Enter Product Code">
</div>

<div class="input-box">
<label>Product Name</label>
<input type="text" name="pname" placeholder="Enter Product Name">
</div>

<div class="input-box">
<label>Product Company</label>
<input type="text" name="pcpny" placeholder="Enter Company Name">
</div>

<div class="input-box">
<label>Product Price</label>
<input type="text" name="pprice" placeholder="Enter Product Price">
</div>

<div class="input-box">
<label>Product Quantity</label>
<input type="text" name="pqty" placeholder="Enter Product Quantity">
</div>

<input type="submit" value="Add Product" class="btn">

</form>

</div>

</body>
</html>