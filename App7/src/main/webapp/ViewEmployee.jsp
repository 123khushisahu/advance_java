<%@page import="com.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>
<center>

<%
ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)request.getAttribute("list");
if(al.size()==0){
	out.println("there are no employee records found!!!");
	
}
else{
	Iterator<EmployeeBean> i=al.iterator();
	while(i.hasNext()){
		EmployeeBean e=i.next();
		out.println(e.getEmp_id()+" "+e.getEmp_fname()+" "+e.getEmp_lname()+" "+e.getEmp_sal()+" "+e.getEmp_addr()+" <br><br>");
	}
}



%>

</h1>
<jsp:include page="index.html" />
</body>
</html>