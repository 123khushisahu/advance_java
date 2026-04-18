
package com.servlet;   //this package use for data setting in html page purpose

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeeBean;
import com.dao.AddEmpDAO;

@WebServlet("/acs")
public class AddEmpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		EmployeeBean ebean=new EmployeeBean();
		
		ebean.setEmp_id(req.getParameter("eid"));
		ebean.setEmp_fname(req.getParameter("efname"));
		ebean.setEmp_lname(req.getParameter("elname"));
		ebean.setEmp_sal(Integer.parseInt(req.getParameter("esal")));
		ebean.setEmp_addr(req.getParameter("addr"));
		AddEmpDAO dao_Obj=new AddEmpDAO();
		int rowCount=dao_Obj.insertEmpData(ebean);
		if(rowCount>0) {
			req.setAttribute("msg","employee data inserted!!!");
			
					req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
					
		}else
			throw new RuntimeException("employee data inserted fail!!!");
	}

}
