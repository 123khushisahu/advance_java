package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UpdateProfileDAO;

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String fname=null;
		Cookie arr[]=req.getCookies();
		if(arr==null) {
			req.setAttribute("msg", "session expired!!");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
			
		}else
		{
			ServletContext context=req.getServletContext();
			UserBean ub=(UserBean)context.getAttribute("ubean");
			ub.setU_fname(req.getParameter("ufname"));
			ub.setU_lname(req.getParameter("ulname"));
			ub.setU_mailid(req.getParameter("umail"));
			ub.setU_phn(req.getParameter("uphn"));
			int rowCount=new UpdateProfileDAO().updateRecord(ub);
			if(rowCount==0) 
				throw new RuntimeException("data not updated!!!");
				else
				{
					req.setAttribute("msg", "Record Updated!!!");
					for(Cookie c:arr)
						if("ck1".equals(c.getName()))
							fname=c.getValue();
					req.setAttribute("fname", fname);
					req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
				}
			}
			
}}
