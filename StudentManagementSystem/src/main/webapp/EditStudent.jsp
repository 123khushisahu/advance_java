<%@ page import="com.Bean.StudentBean" %>

<%

StudentBean s =
(StudentBean)request.getAttribute("student");

%>

<html>
<body>

<h2>Edit Student</h2>

<form action="update" method="post">

<input type="hidden"
       name="sid"
       value="<%=s.getId()%>">

Name:
<input type="text"
       name="sname"
       value="<%=s.getName()%>">

<br><br>

Email:
<input type="text"
       name="semail"
       value="<%=s.getEmail()%>">

<br><br>

Course:
<input type="text"
       name="scourse"
       value="<%=s.getCourse()%>">

<br><br>

<input type="submit"
       value="Update">

</form>

</body>
</html>