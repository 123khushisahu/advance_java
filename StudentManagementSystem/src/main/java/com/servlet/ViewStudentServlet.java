package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.StudentBean;
import com.DAO.StudentDAO;

@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao=new StudentDAO();
		List<StudentBean> list=dao.getAllStudents();
		req.setAttribute("data", list);
		req.getRequestDispatcher("ViewStudent.jsp").forward(req, resp);
		
			}
	

}
