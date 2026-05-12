package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.StudentBean;
import com.DAO.StudentDAO;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {

        // Get form data

        int id =
                Integer.parseInt(
                req.getParameter("sid"));

        String name =
                req.getParameter("sname");

        String email =
                req.getParameter("semail");

        String course =
                req.getParameter("scourse");

        // Create Bean Object

        StudentBean s =
                new StudentBean();

        s.setId(id);
        s.setName(name);
        s.setEmail(email);
        s.setCourse(course);

        // DAO Object

        StudentDAO dao =
                new StudentDAO();

        // Call Update Method

        dao.updateStudent(s);

        // Redirect

        res.sendRedirect("view");
    }
}