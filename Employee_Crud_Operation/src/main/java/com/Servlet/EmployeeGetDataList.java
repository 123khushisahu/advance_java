package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.EmployeePojo;
import com.DAO.EmployeeDAO;

@WebServlet("/GetdataList")
public class EmployeeGetDataList extends HttpServlet {
	
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		 
		   	// StudentDAO dao=new StudentDAO();
			//List<StudentBean> list=dao.getAllStudents();
			//req.setAttribute("data", list);
			EmployeeDAO employeedao=new EmployeeDAO();
			
			List<EmployeePojo> listalldata=employeedao.getEmployeeData();
			
			req.setAttribute("allempdata", listalldata);
			
			
			
			// Get message from URL
	        String msg = req.getParameter("message");
	               

	        req.setAttribute("message", msg);
	               
	               
			req.getRequestDispatcher(
	                "employee_view_list.jsp")
	                .forward(req, resp);
			
			}
}
