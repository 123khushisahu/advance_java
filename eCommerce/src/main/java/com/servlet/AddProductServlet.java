package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProductBean;
import com.dao.AddProductDAO;
@WebServlet("/aps")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("User session is expired!!!");
		}else
		{
			ProductBean pb=new ProductBean();
			pb.setPCODE(req.getParameter("pcode"));
			pb.setPNAME(req.getParameter("pname"));
			pb.setPCOMPANY(req.getParameter("pcpny"));
			pb.setPRICE(req.getParameter("pprice"));
			pb.setPQTY(req.getParameter("pqty"));
			
			int rowCount=new AddProductDAO().insertproduct(pb);
			if(rowCount==0)
				throw new RuntimeException("Product Data Insertion Failed!!!!");
			else
			{
				req.setAttribute("msg","Product Data Inserted");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
	}
	
	

}
