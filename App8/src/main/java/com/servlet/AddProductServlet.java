package com.servlet;   //this package use for data setting in html page purpose

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.AddProductDAO;

@WebServlet("/pcs")
public class AddProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		ProductBean ebean=new ProductBean();
		
		ebean.setpcode(req.getParameter("pcode"));//1
		ebean.setpname(req.getParameter("pname"));//pen
		ebean.setpcompany(req.getParameter("pcompany"));//cello
		ebean.setpprice(Integer.parseInt(req.getParameter("pprice")));//5
		ebean.setpqty(req.getParameter("pqty"));//1
		AddProductDAO dao_Obj=new AddProductDAO();
		int rowCount=dao_Obj.insertprodData(ebean);
		if(rowCount>0) {
			req.setAttribute("msg","product data inserted!!!");
			
					req.getRequestDispatcher("addproduct.jsp").forward(req, res);
					
		}else
			throw new RuntimeException("product data inserted fail!!!");
	}



}
