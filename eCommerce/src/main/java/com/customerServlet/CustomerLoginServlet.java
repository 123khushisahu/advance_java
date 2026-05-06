package com.customerServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerDAO.AddCustomerDAO;
import com.customerbean.CustomerBean;

@WebServlet("/clog")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res)
			throws ServletException, IOException
	{

		HttpSession session=req.getSession(); // create session

		CustomerBean cb=new CustomerBean();

		cb.setC_uname(req.getParameter("uname"));
		cb.setC_pword(req.getParameter("pwd"));
		cb.setC_fname(req.getParameter("fname"));
		cb.setC_lname(req.getParameter("lname"));
		cb.setC_addr(req.getParameter("addr"));
		cb.setC_mid(req.getParameter("mid"));
		cb.setC_phno(req.getParameter("mobile"));

		int rowCount=new AddCustomerDAO().insertCustomer(cb);

		if(rowCount==0)
		{
			req.setAttribute("msg",
					"Customer Data Insertion Failed");

			req.getRequestDispatcher("msg.jsp")
			.forward(req,res);
		}
		else
		{
			session.setAttribute("cbean", cb);

			req.setAttribute("msg",
					"Customer Data Inserted");

			req.getRequestDispatcher("CustomerHome.jsp")
			.forward(req,res);
		}
	}
}