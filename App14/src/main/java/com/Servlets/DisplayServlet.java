package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=req.getServletContext();
		ServletConfig config =this.getServletConfig();
		context.setAttribute("msg1", "This is from ServletContext===>Servlet");
		req.setAttribute("ServletName", config.getServletName());
		req.setAttribute("msg3", config.getInitParameter("msg3"));
		req.getRequestDispatcher("Display.jsp").forward(req, resp);
	}

}
