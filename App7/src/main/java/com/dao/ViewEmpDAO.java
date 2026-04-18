package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.EmployeeBean;

public class ViewEmpDAO {
	public ArrayList<EmployeeBean> a1=new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> reteriveEmpData()
	{
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select*from employee");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				EmployeeBean eb=new EmployeeBean();
				eb.setEmp_id(rs.getString(1));
				eb.setEmp_fname(rs.getString(2));
				eb.setEmp_lname(rs.getString(3));
				eb.setEmp_sal(rs.getInt(4));
				eb.setEmp_addr(rs.getString(5));
				a1.add(eb);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return a1;
	}

}
