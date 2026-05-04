package com.customerServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProductBean;
import com.customerDAO.AddCustomerDAO;
import com.customerbean.CustomerBean;
import com.dao.AddProductDAO;

@WebServlet("/cres")
public class CustomerRegistrationServlet  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("User session is expired!!!");
		}else
		{
			CustomerBean cb=new CustomerBean();
			cb.setC_fname(req.getParameter("uname"));
			cb.setC_pword(req.getParameter("pwd"));
			cb.setC_fname(req.getParameter("fname"));
			cb.setC_lname(req.getParameter("lname"));
			cb.setC_addr(req.getParameter("addr"));
			cb.setC_mid(req.getParameter("mid"));
			cb.setC_phno(req.getParameter("mobile"));
			
			int rowCount=new AddCustomerDAO().insertCustomer(cb);
			if(rowCount==0)
				throw new RuntimeException("Product Data Insertion Failed!!!!");
			else
			{
				req.setAttribute("msg","customer Data Inserted");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
	}
	
	

}


