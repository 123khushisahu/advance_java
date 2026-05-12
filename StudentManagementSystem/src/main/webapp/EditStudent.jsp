
<%@ page import="com.Bean.StudentBean" %>

<%

StudentBean s =
(StudentBean)request.getAttribute("student");

%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edit Student</title>

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
	background:linear-gradient(to right,#ff9966,#ff5e62);
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
	border-color:#ff5e62;
	outline:none;
	box-shadow:0 0 8px rgba(255,94,98,0.5);
}

input[type="submit"]{
	width:100%;
	padding:12px;
	background:#ff5e62;
	color:white;
	border:none;
	border-radius:8px;
	font-size:16px;
	font-weight:bold;
	cursor:pointer;
	transition:0.3s;
}

input[type="submit"]:hover{
	background:#e14b50;
	transform:scale(1.02);
}

.back-link{
	text-align:center;
	margin-top:20px;
}

.back-link a{
	text-decoration:none;
	color:#ff5e62;
	font-weight:bold;
	font-size:16px;
}

.back-link a:hover{
	color:#d6336c;
}

</style>

</head>

<body>

<div class="container">

<h2>Edit Student</h2>

<form action="update" method="post">

<input type="hidden"
       name="sid"
       value="<%=s.getId()%>">

<div class="input-box">
<label>Student Name</label>
<input type="text"
       name="sname"
       value="<%=s.getName()%>">
</div>

<div class="input-box">
<label>Student Email</label>
<input type="text"
       name="semail"
       value="<%=s.getEmail()%>">
</div>

<div class="input-box">
<label>Student Course</label>
<input type="text"
       name="scourse"
       value="<%=s.getCourse()%>">
</div>

<input type="submit"
       value="Update Student">

</form>

<div class="back-link">
<a href="view">View Students</a>
</div>

</div>

</body>
</html>
```
