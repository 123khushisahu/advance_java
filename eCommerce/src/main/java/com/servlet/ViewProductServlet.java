package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProductBean;
import com.dao.ViewProductDAO;

@WebServlet("/view1")
public class ViewProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServerException,IOException, ServletException{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			throw new RuntimeException("session expired!!!");
			
		}else
		{
			ArrayList<ProductBean> a1=new ViewProductDAO().reteriveProductInfo();
			session.setAttribute("ProductList", a1);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
		
	}

}
