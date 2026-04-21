package com.dao;      //this package use for Connection/data  setting purpose in database

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.ProductBean;

public class AddProductDAO {
	public int insertprodData(ProductBean eb)
	{
		int rowCount=0;
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?,?)");
			
			pstmt.setString(1, eb.getpcode());
			pstmt.setString(2, eb.getpname());
			pstmt.setString(3, eb.getpcompany());
			pstmt.setInt(4, eb.getpprice());		
			pstmt.setString(5, eb.getpqty());
			rowCount=pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();		
			}
			return rowCount;
		}

}
