package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDAO;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        // get id from URL
        int id = Integer.parseInt(
                req.getParameter("id"));

        // create DAO object
        StudentDAO dao = new StudentDAO();

        // call delete method
        dao.deleteStudent(id);

        // redirect to view page
        resp.sendRedirect("view");
    }
}