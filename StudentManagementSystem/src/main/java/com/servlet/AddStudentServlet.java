package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.StudentBean;
import com.DAO.StudentDAO;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("sname");
		String email=req.getParameter("semail");
		String course=req.getParameter("scourse");
		StudentBean s=new StudentBean();
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);
		StudentDAO dao=new StudentDAO();
		dao.saveStudent(s);
		res.sendRedirect("view");
	}
	

}
