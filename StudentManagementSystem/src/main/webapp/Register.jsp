<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Register Student</title>
</head>

<body>

<h2>Student Registration Form</h2>

<form action="add" method="post">

Student Id :
<input type="text" name="sid">
<br><br>

Student Name :
<input type="text" name="sname">
<br><br>

Student Email :
<input type="text" name="semail">
<br><br>

Student Course :
<input type="text" name="scourse">
<br><br>

<input type="submit" value="Register">

</form>

<br>

<a href="view">View Students</a>

</body>
</html>