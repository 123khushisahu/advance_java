package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserRegisterDAO;

@WebServlet("/reg")
public class UserRegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub=new UserBean();
		ub.setU_name(req.getParameter("uname"));
		ub.setU_pwd(req.getParameter("upwd"));
		ub.setU_fname(req.getParameter("ufname"));
		ub.setU_lname(req.getParameter("ulname"));
		ub.setU_mailid(req.getParameter("umail"));
		ub.setU_phn(req.getParameter("uphn")); 
		
		int rowCount=new UserRegisterDAO().register(ub);
		if(rowCount>0) {
			req.setAttribute("msg", "user register successfully!!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}else {
			req.setAttribute("msg","User Registration Failed");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		
	}

}
