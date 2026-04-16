package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@WebServlet("/ss")
public class SubstractionServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res, String Sub) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int i=Integer.parseInt(req.getParameter("num"));
		pw.println("<h><center>");
		pw.println("the substraction is" +Sub);
		pw.println("</h></center>");
		
	}

}
