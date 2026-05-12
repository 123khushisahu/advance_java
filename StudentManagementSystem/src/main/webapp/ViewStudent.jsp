<%@ page import="java.util.*,com.Bean.StudentBean" %>

<html>

<body>

<h2>Student List</h2>

<table border="1">

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
<a href="edit?id=<%=s.getId()%>">
Edit
</a>
</td>

<td>
<a href="delete?id=<%=s.getId()%>">
Delete
</a>
</td>

</tr>

<%
}
%>

</table>

<br>

<a href="AddStudent.jsp">
Add New Student
</a>

</body>
</html>