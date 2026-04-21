
<%@ page import="java.util.*, com.bean.ProductBean" %>
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
ArrayList<ProductBean> al=(ArrayList<ProductBean>)request.getAttribute("list");
if(al.size()==0){
	out.println("there are no product records found!!!");
	
}
else{
	Iterator<ProductBean> i=al.iterator();
	while(i.hasNext()){
		ProductBean e=i.next();
		out.println(e.getpcode()+" "+e.getpname()+" "+e.getpcompany()+" "+e.getpprice()+" "+e.getpqty()+" <br><br>");
	}
}



%>

</h1>
<jsp:include page="index.html" />

</body>
</html>