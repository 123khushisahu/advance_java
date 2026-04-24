package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View")
public class ViewProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		String fname=null;
		Cookie arr[]=req.getCookies();
		if(arr==null) {
			req.setAttribute("msg","session Expired");
			req.getRequestDispatcher("Register.jsp").forward(req,res);
		}
		else {
			for(Cookie c:arr)
				if("ck1".equals(c.getName()))
					fname=c.getValue();
			req.setAttribute("fname", fname);
			req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
		}
	}

}
