package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/stuservlet")
public class StudentServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String s_name = req.getParameter("sname");
		String s_branch = req.getParameter("sbranch");
		String s_rollno = req.getParameter("srollno");
		String s_marks = req.getParameter("smarks");

		pw.println("<h1><center>");

		pw.println("***********studebt data********"+"<br><br>");
		pw.println("student name:" + s_name + "<br><br>");
		pw.println("student name:" + s_branch + "<br><br>");
		pw.println("student name:" + s_rollno + "<br><br>");
		pw.println("student name:" + s_marks + "<br><br>");

		pw.println("</h1></center>");

	}

}
