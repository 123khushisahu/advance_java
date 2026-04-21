package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/fs")
public class FactorialServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	PrintWriter pw=	res.getWriter();
	res.setContentType("text/html");
	int i=Integer.parseInt(req.getParameter("num"));
	int fact=1;
	for(;i>=1;i--) {
		fact=fact*i;
	}
	pw.println("<h><center>");
	pw.println("the factorial is" +fact);
	pw.println("</h></center>");
	//req.getRequestDispatcher("index.html").include(req,res);     //without use i can work  of directly in browser if 
	//i use this  then need of refresh that then after  i can use of button
	
	}

}
