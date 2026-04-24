package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserBean;

public class UpdateProfileDAO {
public int updateRecord(UserBean ub)
{
	int rowCount=0;
	try {
		Connection con=DBConnect.getcon();
		PreparedStatement pstmt=con.prepareStatement("update registration set firstname=?,lastname=?,mailid=?,phone=? where username=?");
		pstmt.setString(1, ub.getU_fname());
		pstmt.setString(2, ub.getU_lname());
		pstmt.setString(3, ub.getU_mailid());
		pstmt.setString(4, ub.getU_phn());
		pstmt.setString(5, ub.getU_name());
		rowCount=pstmt.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return rowCount;
}
}
