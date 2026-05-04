package com.customerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.customerbean.CustomerBean;

public class CustomerLoginDAO {

	

		public CustomerBean checkAdminLogin(String uname,String upwd) {
			CustomerBean ab=null;
			try {
				Connection con=DBConnect.getCon();
				PreparedStatement pstmt=con.prepareStatement("select*from customer where uname=? and pword=?");
				pstmt.setString(1, uname);
				pstmt.setString(2, upwd);
				ResultSet rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					ab.setC_uname(rs.getString(1));
					ab.setC_pword(rs.getString(2));
					ab.setC_fname(rs.getString(3));
					ab.setC_lname(rs.getString(4));
					ab.setC_addr(rs.getString(5));
					ab.setC_mid(rs.getString(6));
					ab.setC_phno(rs.getString(7));
				}
			}catch(Exception e) {
			e.printStackTrace();	
			}
			return ab;
			
		}
	}

		

