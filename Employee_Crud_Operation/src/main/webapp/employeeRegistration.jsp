<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.Bean.EmployeePojo" %>
    
    <%

    EmployeePojo emp =
(EmployeePojo)request.getAttribute("employee");

%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Employee Registration Form</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet">

<style>

body{
	background: linear-gradient(to right,#4facfe,#00f2fe);
	font-family: Arial, sans-serif;
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.main-box{
	width: 100%;
	max-width: 600px;
	background: white;
	padding: 35px;
	border-radius: 15px;
	box-shadow: 0px 5px 20px rgba(0,0,0,0.2);
}

h1{
	font-size: 32px;
	font-weight: bold;
	color: #333;
}

.form-label{
	font-weight: 600;
	margin-bottom: 6px;
}

.form-control{
	height: 45px;
	border-radius: 8px;
}

.btn-custom{
	width: 100%;
	height: 45px;
	font-size: 18px;
	font-weight: bold;
	border-radius: 8px;
}

.top-btn{
	margin-bottom: 20px;
}

</style>

</head>

<body>




<div class="main-box">

<h1 class="text-center mb-4">Employee Registration</h1>

<div class="text-center top-btn">
	<a href="GetdataList" class="btn btn-primary">
		Show Employee List
	</a>
</div>

<form action="empSaveData" method="post">


 <input type="hidden" name="nameId" id="idvalue" value="<%= (emp != null) ? emp.getId() : "" %>"  >
<br>

	<div class="mb-3">
		<label class="form-label">Employee Id</label>
		<input type="number"
name="emp_id"
value="<%= (emp != null) ? emp.getEmp_id() : "" %>"
placeholder="Enter Employee Id"
class="form-control">
	</div>

	<div class="mb-3">
		<label class="form-label">Employee Name</label>
		<input type="text" name="empName" value="<%= (emp != null) ? emp.getEmpName() : "" %>"
		placeholder="Enter Employee Name"
		class="form-control">
	</div>

	<div class="mb-3">
		<label class="form-label">Employee Address</label>
		<input type="text" name="address" value="<%= (emp != null) ? emp.getAddress() : "" %>"
		placeholder="Enter Employee Address"
		class="form-control">
	</div>

	<div class="mb-3">
		<label class="form-label">Employee Email</label>
		<input type="email" name="email"   value="<%= (emp != null) ? emp.getEmail() : "" %>"
		placeholder="Enter Employee Email"
		class="form-control">
	</div>

	<div class="mb-3">
		<label class="form-label">Employee Mobile No</label>
		<input type="text" name="mobNo"    value="<%= (emp != null) ? emp.getMobNo() : "" %>"
		placeholder="Enter Mobile Number"
		class="form-control">
	</div>

	<div class="mb-4">
		<label class="form-label">Employee Department</label>
		<input type="text" name="empDept"  value="<%= (emp != null) ? emp.getEmpDept() : "" %>"
		placeholder="Enter Department"
		class="form-control">
	</div>

	<input type="submit"
	value="Register Data"
	class="btn btn-success btn-custom">

</form>

</div>

</body>
</html>