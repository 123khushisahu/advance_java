package com.servlet;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminLoginDAO;
@WebServlet("/alog")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		AdminBean abean=new AdminLoginDAO().checkAdminLogin(req.getParameter("aname"),req.getParameter("apwd"));
		if(abean==null)
		{
			req.setAttribute("msg", "Session Expired!!!!");
			req.getRequestDispatcher("AdminLogin.html").forward(req,res);
			
		}
		else
		{
			HttpSession session=req.getSession();
			session.setAttribute("AdminBean",abean);
			req.getRequestDispatcher("AdminHome.jsp").forward(req,res);
		}
	}

}
