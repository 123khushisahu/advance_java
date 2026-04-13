package com.pack1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/fs")
public class FirstServlet extends GenericServlet{

	
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		String user_name=req.getParameter("uname");
		String user_pwd=req.getParameter("upwd");
		System.out.println("data entered by the user");
		System.out.println("USERNAME:"+user_name);
		System.out.println("password:"+user_pwd);
	}

}
