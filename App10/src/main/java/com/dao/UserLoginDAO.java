package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;

public class UserLoginDAO {
	public UserBean checkLogin(String uname,String upwd)
	{
		UserBean ub=null;
		try {
			Connection con=DBConnect.getcon();
			PreparedStatement pstmt=con.prepareStatement("select * from registration where USERNAME=? and PASSWORD=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				ub= new UserBean();
				ub.setU_name(rs.getString(1));
				ub.setU_pwd(rs.getString(2));
				ub.setU_fname(rs.getString(3));
				ub.setU_lname(rs.getString(4));
				ub.setU_mailid(rs.getString(5));
				ub.setU_phn(rs.getString(6));
				
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ub;
		
	}

}
