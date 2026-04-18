package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeeBean;
import com.dao.ViewEmpDAO;
@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServerException,IOException, ServletException{
		ArrayList<EmployeeBean> a1=new ViewEmpDAO().reteriveEmpData();
		req.setAttribute("list", a1);
		req.getRequestDispatcher("ViewEmployee.jsp").forward(req, res);
	}

}
