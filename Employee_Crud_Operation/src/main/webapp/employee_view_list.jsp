
<%@page import="java.util.*"%>
<%@page import="com.Bean.EmployeePojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Employee List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>

<body>

<br><br>

<h1 style="text-align:center; color:red;">
    <u>Employee List Page</u>
</h1>

<br>
<br>
<div style="text-align: center;">
<a href="employeeRegistration.jsp" >
<button class="btn btn-primary">Add New Employee</button>
</a>
</div>
<br><br>
<%--      java code reading purpose use this tag <%  %>                --%> 

<% 
 String msg=  (String)request.getAttribute("message");
%>

<% 
 String msg1=  (String)request.getAttribute("message");
%>

<!--  Expression Tag in JSP JSP me  ko Expression Tag bolte hain. Iska use value ko browser par
 print/display karne ke liye hota hai.  -->

 <%-- for printing any message on jsp page use <%= %>  --%>

<h4 style="text-align: center;color: green;"><%= (msg!=null) ? msg:"" %></h4>


<br><br>

<table border="2"
style="border-collapse:separate; margin-left:24%;"
class="table table-bordered w-50">

    <thead style="color: blue;
    background: antiquewhite;">

        <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Address</th>
            <th>Employee Email</th>
            <th>Employee Mobile Number</th>
            <th>Employee Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

    </thead>

    <tbody>

    <%
        List<EmployeePojo> list =
        (List<EmployeePojo>)request.getAttribute("allempdata");

        for(EmployeePojo e : list){
    %>

        <tr>

            <td><%=e.getEmp_id()%></td>
            <td><%=e.getEmpName()%></td>
            <td><%=e.getAddress()%></td>
            <td><%=e.getEmail()%></td>
            <td><%=e.getMobNo()%></td>
            <td><%=e.getEmpDept()%></td>

            <td>
                <a class="btn btn-success"
                href="editEmployee?id=<%=e.getId()%>">
                Edit
                </a>
            </td>

            <td>
                <a class="btn btn-danger"
                href="deleteEmployee?id=<%=e.getEmp_id()%>">
                Delete
                </a>
            </td>

        </tr>

    <%
        }
    %>

    </tbody>

</table>



</body>
</html>