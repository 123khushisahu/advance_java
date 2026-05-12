package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.StudentBean;
import com.DAO.StudentDAO;

@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        int id =
                Integer.parseInt(
                req.getParameter("id"));

        StudentDAO dao =
                new StudentDAO();

        StudentBean s =
                dao.getsaveStudentById(id);

        req.setAttribute("student", s);

        req.getRequestDispatcher(
                "EditStudent.jsp")
                .forward(req, res);
    }
}