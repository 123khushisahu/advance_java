package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/es")

public class EvenServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	PrintWriter pw=	res.getWriter();
	res.setContentType("text/html");
	int i=Integer.parseInt(req.getParameter("num"));
	
	pw.println("<h><center>");
	if(i%2==0) {
		pw.println(i+ "is a even number");
	}
	else {
		pw.println(i+ "is a odd number");
		pw.println("</h></center>");
		req.getRequestDispatcher("index.html").include(req,res);

		}
	}
}
