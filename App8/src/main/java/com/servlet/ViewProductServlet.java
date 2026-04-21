package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ViewProductDAO;

@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServerException,IOException, ServletException{
		ArrayList<ProductBean> a1=new ViewProductDAO().reteriveEmpData();
		req.setAttribute("list", a1);
		req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
	}

}
