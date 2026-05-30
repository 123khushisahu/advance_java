package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Bean.EmployeePojo;


public class EmployeeDAO {

//	public void UpdateData(EmployeePojo emppojo) {
//		
//		
//		
//	}
//	
	
	
	
	/* save methods */
	public int saveMethods(EmployeePojo emppojo) {

	    int rowCount = 0;

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(
	                "INSERT INTO EMPLOYEE_REGISTRAION\r\n"
	                + "(EMP_NAME, EMP_ID, EMP_ADDRESS, EMAIL, MOB_NO, EMP_DEPT)\r\n"
	                + "VALUES (?,?,?,?,?,?)");

	        pstmt.setString(1, emppojo.getEmpName());
	        pstmt.setInt(2, emppojo.getEmp_id());
	        pstmt.setString(3, emppojo.getAddress());
	        pstmt.setString(4, emppojo.getEmail());
	        pstmt.setLong(5, emppojo.getMobNo());
	        pstmt.setString(6, emppojo.getEmpDept());

	        rowCount = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowCount;
	}

	
	
	
	
	/* get data list methods */
	public List<EmployeePojo> getEmployeeData() {

	    List<EmployeePojo> list = new ArrayList<>();

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	            con.prepareStatement("SELECT * FROM EMPLOYEE_REGISTRAION");

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {

	            EmployeePojo emp = new EmployeePojo();

	            emp.setId(rs.getInt("id"));
	            emp.setEmpName(rs.getString("EMP_NAME"));
	            emp.setEmp_id(rs.getInt("EMP_ID"));
	            emp.setAddress(rs.getString("EMP_ADDRESS"));
	            emp.setEmail(rs.getString("EMAIL"));
	            emp.setMobNo(rs.getLong("MOB_NO"));
	            emp.setEmpDept(rs.getString("EMP_DEPT"));

	            list.add(emp);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
		
		
	

		
		
		
	}
	
	
	


