<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "com.bean.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<%
String fname=(String)request.getAttribute("fname");
UserBean ub=(UserBean)application.getAttribute("ubean");
out.println("This session belong to:"+fname+"<br><br>");
out.println("<u>Edit profile portal</u><br><br>");
%>
<form action="update" method="post">
FirstName<input type="text" name="ufname" value="<%=ub.getU_fname()%>"><br><br>
LastName<input type="text" name="ulname" value="<%=ub.getU_lname()%>"><br><br>
MailId<input type="text" name="umail" value="<%=ub.getU_mailid()%>"><br><br>
Phone Number<input type="text" name="uphn" value="<%= ub.getU_phn()%>"><br><br>
<input type="submit" value="update">


</form>
</h1></center>

</body>
</html>