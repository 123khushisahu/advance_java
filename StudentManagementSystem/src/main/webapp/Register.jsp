```jsp id="v9y8z2"
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Register Student</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:Arial, sans-serif;
}

body{
	height:100vh;
	display:flex;
	justify-content:center;
	align-items:center;
	background:linear-gradient(to right,#667eea,#764ba2);
}

.container{
	width:420px;
	background:white;
	padding:35px;
	border-radius:15px;
	box-shadow:0px 0px 20px rgba(0,0,0,0.3);
}

h2{
	text-align:center;
	margin-bottom:25px;
	color:#333;
}

.input-box{
	margin-bottom:18px;
}

label{
	display:block;
	margin-bottom:6px;
	font-weight:bold;
	color:#444;
}

input[type="text"]{
	width:100%;
	padding:12px;
	border:1px solid #ccc;
	border-radius:8px;
	font-size:15px;
	transition:0.3s;
}

input[type="text"]:focus{
	border-color:#667eea;
	outline:none;
	box-shadow:0 0 8px rgba(102,126,234,0.5);
}

input[type="submit"]{
	width:100%;
	padding:12px;
	background:#667eea;
	color:white;
	border:none;
	border-radius:8px;
	font-size:16px;
	font-weight:bold;
	cursor:pointer;
	transition:0.3s;
}

input[type="submit"]:hover{
	background:#5a67d8;
	transform:scale(1.02);
}

.view-link{
	text-align:center;
	margin-top:20px;
}

.view-link a{
	text-decoration:none;
	color:#667eea;
	font-weight:bold;
	font-size:16px;
}

.view-link a:hover{
	color:#764ba2;
}

</style>

</head>

<body>

<div class="container">

<h2>Student Registration Form</h2>

<form action="add" method="post">



<div class="input-box">
<label>Student Name</label>
<input type="text" name="sname" placeholder="Enter Student Name">
</div>

<div class="input-box">
<label>Student Email</label>
<input type="text" name="semail" placeholder="Enter Student Email">
</div>

<div class="input-box">
<label>Student Course</label>
<input type="text" name="scourse" placeholder="Enter Student Course">
</div>

<input type="submit" value="Register Student">

</form>

<div class="view-link">
<a href="view">View Students</a>
</div>

</div>

</body>
</html>
```
