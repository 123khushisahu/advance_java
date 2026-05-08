<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
    <%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!				/*declaration*/

int findFactorial(int x)//=5
{
	int fact=1;
	for(;x>=1;x--)
		fact=fact*x;
	return fact;
}

%>
<%int i=Integer.parseInt(request.getParameter("num"));
int result=findFactorial(i);
out.println("<center><h1>Factorial is :"+result+"</h1></center><br>");


%>

<%@ include file="input.html" %>

</body>
</html>