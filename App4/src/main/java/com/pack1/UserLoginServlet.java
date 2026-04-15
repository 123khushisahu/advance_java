package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/userservlet")
public class UserLoginServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String u_name = req.getParameter("uname");
		String u_password = req.getParameter("pwd");
		String name="java";
		pw.println("<h1><center>");

		pw.println("***********User Data********" +"<br><br>");
		pw.println("User Name:" + u_name + "<br><br>");
		pw.println("User Password:" + u_password + "<br><br>");
		if(u_password.equals("javaisaswesome")&&u_name.equals(name)) {
		pw.println("welcome"+u_name);
		pw.println("you did the task");
		pw.println("</h1></center>");
		
	}
	else {
		pw.println("welcome"+u_name);
		pw.println("invalid credential!!!!!");
		
	}

	}
}
