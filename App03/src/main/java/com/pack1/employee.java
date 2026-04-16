package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/task1servlet")
public class employee extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=	res.getWriter();
		res.setContentType("text/html");
		String e_name=req.getParameter("ename");
		String e_id=req.getParameter("eid");
		double e_sal=Integet.parseInt(req.getParameter("esal");)
//		String e_sal=req.getParameter("esal");
//		String e_exp=req.getParameter("eexp");
//		
		double sal=Double.parseDouble(e_sal);
		int exp=Integer.parseInt(e_exp);
		if(exp>=5) {
			sal=(sal +(sal * 0.10));
	 
				 
			 }
		pw.println("<h1><center>");
		pw.println("***********employee details********"+"<br><br>");
		pw.println("employee name:"+e_name+"<br><br>");
		pw.println("employee id:"+e_id+"<br><br>");
		pw.println("employee sal:"+sal+"<br><br>");
		pw.println("employee exp:"+e_exp+"<br><br>");
		
//		pw.println("DEBUG exp = " + exp + "<br>");
//		pw.println("DEBUG salary before = " + sal + "<br>");
//
		pw.println("</h1></center>");
		
		
		
		
		}

}
