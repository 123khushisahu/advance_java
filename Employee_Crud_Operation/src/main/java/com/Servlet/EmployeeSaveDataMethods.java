package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.EmployeePojo;
import com.DAO.EmployeeDAO;

//database me save kr rhe h
@WebServlet("/empSaveData")
public class EmployeeSaveDataMethods extends HttpServlet {
				//dopost bcz database me send
				//doget database se fetch	
				//	HttpServletRequest
				//
				//	Client/browser pe/jsp page me द्वारा भेजे गए request data (form data, parameters, headers, 
				//		session information) को प्राप्त करने के लिए उपयोग किया जाता है।
				//
				//	HttpServletResponse
				//
				//	Servlet से client/browser को response भेजने के लिए उपयोग किया जाता है,
				//	जैसे redirect करना, HTML भेजना, message भेजना आदि।
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
				//"Request में जो nameId नाम का data आया है उसकी value निकालो"
				//jsp(browser) p jaise id=101 pass kiya after jaise hi save kiya after
				//ye line us data ko catch/bind/pakdega/store karega
		 String empid = req.getParameter("nameId") ;
				//req = HttpServletRequest
				//इसमें browser/form से भेजा गया सारा data होता है।		   
				//this is for Edit/Update data in database 
		   		//yahi se backend me check hota hai
		   		// THIS IS FOR UPDATE METHODS WHILE UPDATE/EDIT   IT WILL WORK
				if(empid !=null && !empid.isBlank() && !empid.isEmpty()) {
					String emp_id = req.getParameter("emp_id") ;
					String empName = req.getParameter("empName");
					String address = req.getParameter("address");
					String email = req.getParameter("email");
					String mobNo = req.getParameter("mobNo");
					String empDept = req.getParameter("empDept");
					String id=req.getParameter(empid);

					System.out.println("Servlet Hit Successfully");

					EmployeePojo emppojo = new EmployeePojo();

					emppojo.setEmp_id(Integer.parseInt(emp_id));
					emppojo.setEmpName(empName);
					emppojo.setAddress(address);
					emppojo.setEmail(email);
					emppojo.setMobNo(Long.parseLong(mobNo));
					emppojo.setEmpDept(empDept);
					emppojo.setId(Integer.parseInt(empid));
					
					EmployeeDAO empdao = new EmployeeDAO();

					empdao.updateMethod(emppojo);

					//res.sendRedirect("GetdataList");
					 // Redirect with message
				    res.sendRedirect("GetdataList?message=Data Updated Successfully!" );
				        
				   

			
		       }
				
				//this is for save methods fresh new data 
				//means for add new employee pwork
				//jsp p fill kiya  fir jaise hi save button p click kiya uske baad ye us data ko bind karega
				//yaha pr esliye aaya qki table(database) me abhi id save hi nahi hue hai
				else {
					String emp_id = req.getParameter("emp_id") ;
					String empName = req.getParameter("empName");
					String address = req.getParameter("address");
					String email = req.getParameter("email");
					String mobNo = req.getParameter("mobNo");
					String empDept = req.getParameter("empDept");

					System.out.println("Servlet Hit Successfully");

					EmployeePojo emppojo = new EmployeePojo();
			//emppojo  ko select kiya fir ctrl+shift+i p click then database me kya ja rha hai vah dikhega
					emppojo.setEmp_id(Integer.parseInt(emp_id));
					emppojo.setEmpName(empName);
					emppojo.setAddress(address);
					emppojo.setEmail(email);
					emppojo.setMobNo(Long.parseLong(mobNo));
					emppojo.setEmpDept(empDept);

					EmployeeDAO empdao = new EmployeeDAO();

					empdao.saveMethods(emppojo);

					System.out.println("Data Saved Successfully!");

			//res.sendRedirect("GetdataList");
					
				    res.sendRedirect("GetdataList?message=Data inserted Successfully!" );

					
				}	
		}
}







//Operation||Method
//Show Data	    GET
//Search Data	GET
//Save Data	    POST
//Update Data	POST
//Delete  Data	POST (या DELETE)

//Employee form data database में save/update करना है, 
//इसलिए HTTP POST method use किया जाता है। POST request
//data को request body में भेजती है, URL में नहीं दिखाती और database
//modification operations (Insert/Update) के लिए suitable होती है।
//






