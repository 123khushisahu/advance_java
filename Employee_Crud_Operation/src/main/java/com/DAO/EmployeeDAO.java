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
	//CRUD=(create/insert,retrieve/read,update,delete)
	
	
	
	/* save methods */
	public int saveMethods(EmployeePojo emppojo) {

	    int rowCount = 0;

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(
	                "INSERT INTO EMPLOYEE_REGISTRAION\r\n"
	                + "(EMP_NAME, EMP_ID, EMP_ADDRESS, EMAIL, MOB_NO, EMP_DEPT)\r\n"
	                + "VALUES (?,?,?,?,?,?)");
	//emppojo me data hai ab vo one by one pstmt me set kar raha hai!
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





	public EmployeePojo getEmployeeDataById(int id) {

	    EmployeePojo emp = null;

	    try {
	        Connection con = DBConnection.getConnection();

	        String query = "select * from EMPLOYEE_REGISTRAION where id=?";

	        PreparedStatement pstmt = con.prepareStatement(query);

	        pstmt.setInt(1, id);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            emp = new EmployeePojo();

	            
	            emp.setId(rs.getInt("id"));
	            emp.setEmpName(rs.getString("emp_name"));
	            emp.setEmp_id(rs.getInt("emp_id"));
	            emp.setAddress(rs.getString("emp_address"));
	            emp.setEmail(rs.getString("email"));
	            emp.setMobNo(rs.getLong("mob_no"));
	            emp.setEmpDept(rs.getString("emp_dept"));

	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return emp;
	}





	
	
	/* update methods */
	public int updateMethod(EmployeePojo emppojo) {

	    int rowCount = 0;

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt = con.prepareStatement(
	                "UPDATE EMPLOYEE_REGISTRAION "
	                + "SET emp_id=?, EMP_NAME=?, EMP_ADDRESS=?, EMAIL=?, MOB_NO=?, EMP_DEPT=? "
	                + "WHERE id=?");

	        pstmt.setInt(1, emppojo.getEmp_id());
	        pstmt.setString(2, emppojo.getEmpName());
	        pstmt.setString(3, emppojo.getAddress());
	        pstmt.setString(4, emppojo.getEmail());
	        pstmt.setLong(5, emppojo.getMobNo());
	        pstmt.setString(6, emppojo.getEmpDept());
	        pstmt.setInt(7, emppojo.getId());
	       

	        rowCount = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowCount;
	}





	public int deletedataById(int id) {

	    int rowCount = 0;

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pstmt =
	                con.prepareStatement(
	                "DELETE FROM EMPLOYEE_REGISTRAION WHERE ID=?");

	        pstmt.setInt(1, id);

	        rowCount = pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowCount;
	}
	
}
	
	
	


