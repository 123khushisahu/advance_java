package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProductBean;
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServerException,IOException, ServletException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
			throw new RuntimeException("session expired!!");
		else
		{
			String pcode=req.getParameter("pcode");
			ArrayList<ProductBean>a1=(ArrayList<ProductBean>)session.getAttribute("ProductList");
			ProductBean pb=null;
			Iterator<ProductBean> i=a1.iterator();
			while(i.hasNext())
			{
				pb=i.next();
				if(pcode.equals(pb.getPCODE()))
				{
					break;
				}
			}
			req.setAttribute("pbean",pb);
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
	}

}
