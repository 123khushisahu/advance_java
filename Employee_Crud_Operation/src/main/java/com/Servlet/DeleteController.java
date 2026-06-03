package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;

@WebServlet("/deletedata")
public class DeleteController extends HttpServlet {
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    int id = Integer.parseInt(
	            req.getParameter("id"));

	    EmployeeDAO dao = new EmployeeDAO();

	    int rowCount = dao.deletedataById(id);

	    if (rowCount > 0) {
            res.setStatus(HttpServletResponse.SC_OK);
        } 
	    else {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

	    
		
	}
}
