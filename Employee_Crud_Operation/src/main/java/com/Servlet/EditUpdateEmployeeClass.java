package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.EmployeePojo;
import com.DAO.EmployeeDAO;

//Edit Update data methods 
	@WebServlet("/editEmployee")
public class EditUpdateEmployeeClass extends HttpServlet {
		
		@Override
	    protected void doGet(HttpServletRequest req,  HttpServletResponse res)
	            throws ServletException, IOException {
			
			int id =
	                Integer.parseInt(
	                req.getParameter("id"));

	        EmployeeDAO dao =new EmployeeDAO();
	                

	        EmployeePojo emp =dao.getEmployeeDataById(id);
	                

	        req.setAttribute("employee", emp);

	        req.getRequestDispatcher(
	                "employeeRegistration.jsp")
	                .forward(req, res);
			
			
	        
		
		}
	


}
