package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/productServlet")
public class ProductServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String p_name = req.getParameter("pname");
		String p_Id =req.getParameter("pid");
        int  p_qty =Integer.parseInt( req.getParameter("pquantity"));
	  double pprice=Double.parseDouble( req.getParameter("pprice"));
	//if productqty <= 5 increase the product  price 10% 
		if(p_qty<=5) {
		     pprice = pprice + (pprice * 10 / 100);
		}else
		{
			pprice=pprice*p_qty;
		}
		pw.print("*****************************");
		pw.print("\nproduct name"+p_name);
		pw.print("\nProduct Id"+p_Id);
		pw.print("\nProduct qty"+p_qty);
		pw.print("\nfinal Product_price"+pprice);
	}
	}


