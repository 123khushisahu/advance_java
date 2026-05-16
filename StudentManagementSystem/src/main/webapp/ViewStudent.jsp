
<%@ page import="java.util.*,com.Bean.StudentBean" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Student List</title>


<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:Arial, sans-serif;
}

body{
	background:linear-gradient(to right,#36d1dc,#5b86e5);
	min-height:100vh;
	padding:40px;
}

.container{
	width:90%;
	margin:auto;
	background:white;
	padding:30px;
	border-radius:15px;
	box-shadow:10px 10px 20px red;
}

h2{
	text-align:center;
	margin-bottom:25px;
	color:#333;
}

table{
	width:100%;
	border-collapse:separate;
}

table th{
	background:#5b86e5;
	color:black;
	padding:14px;
	font-size:17px;
}

table td{
	padding:12px;
	text-align:center;
border-bottom:2px solid green;
	border-top:3px solid black;
	border-left:2px solid orange;
	border-right:3px solid blue;
	
}

table tr:hover{
	background:yellow;
}

.edit-btn{
	text-decoration:none;
	background:#28a745;
	color:white;
	padding:8px 14px;
	border-radius:6px;
	font-size:14px;
	font-weight:bold;
}

.edit-btn:hover{
	background:red;
}

.delete-btn{
	text-decoration:none;
	background:black;
	color:white;
	padding:8px 14px;
	border-radius:6px;
	font-size:14px;
	font-weight:bold;
}

.delete-btn:hover{
	background:aqua;
}

.add-btn{
	display:inline-block;
	margin-top:20px;
	text-decoration:none;
	background:#007bff;
	color:white;
	padding:12px 20px;
	border-radius:8px;
	font-size:16px;
	font-weight:bold;
}

.add-btn:hover{
	background:#0056b3;
}

.button-area{
	text-align:center;
}

</style>

</head>

<body>



<div class="container">

<h2><u>Student List</u></h2>
<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%

List<StudentBean> list =
(List<StudentBean>)request.getAttribute("data");

for(StudentBean s : list){

%>

<tr>

<td><%=s.getId()%></td>
<td><%=s.getName()%></td>
<td><%=s.getEmail()%></td>
<td><%=s.getCourse()%></td>

<td>
<a class="edit-btn"
href="edit?id=<%=s.getId()%>"
onclick="return confirm('Are you sure! you want to change?')">
Edit
</a>
</td>

<td>
<a class="delete-btn"
href="delete?id=<%=s.getId()%>"
onclick="return confirm('Are you sure to delete?')">
Delete
</a>
</td>

</tr>

<%
}
%>

</table>

<div class="button-area">
<a class="add-btn" href="index.html"
onclick="return confirm('Are you sure!')">
 Add New Student
</a>
</div>




</div>

</body>
</html>
```
