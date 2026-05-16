<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.pack1.UserBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Page</title>
</head>

<body>

<center>
<h1>

<jsp:useBean id="ub" class="com.pack1.UserBean" scope="session"/>

UserName:
<jsp:getProperty property="userName" name="ub"/><br>

Mail_id:
<jsp:getProperty property="userMail" name="ub"/><br>

Mobile:
<jsp:getProperty property="userMob" name="ub"/><br>

</h1>
</center>

</body>
</html>