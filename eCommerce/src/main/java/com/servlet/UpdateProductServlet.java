package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ProductBean;
import com.dao.UpdateProductDAO;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if(session == null)
		{
			throw new RuntimeException("Session Expired!!!!");
		}
		else
		{
			ProductBean pb = new ProductBean();

			pb.setPRICE(req.getParameter("p_price"));
			pb.setPQTY(req.getParameter("p_qty"));
			pb.setPCODE(req.getParameter("p_code"));

			int rowCount = new UpdateProductDAO().updateProduct(pb);

			if(rowCount > 0)
			{
				req.setAttribute("msg", "Product Updated Successfully...");
			}
			else
			{
				req.setAttribute("msg", "Product Not Updated...");
			}

			req.getRequestDispatcher("UpdateProduct.jsp")
			.forward(req, res);
		}
	}
}