package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dis")
public class ControllerServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	/*ServletContext  context=this.getServletContext();
	HttpSession session=req.getSession();
	context.setAttribute();
	session.setAttribute();
	req.setAttribute();
	req.getRequestDispatcher("Display.jsp").forward(req,res);*/
		

		String name = req.getParameter("uname");

		// Application Scope
		ServletContext context = this.getServletContext();
		context.setAttribute("a", "Application Data");

		// Session Scope
		HttpSession session = req.getSession();
		session.setAttribute("b", "Session Data");

		// Request Scope
		req.setAttribute("c", "Request Data");

		// Forward to JSP
		req.getRequestDispatcher("Display.jsp").forward(req, res);

		
}
}