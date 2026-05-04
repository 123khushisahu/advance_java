package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.ProductBean;

public class UpdateProductDAO {
	public int updateProduct(ProductBean pb) {
		int rowCount=0;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update product1 set price=?,pqty=? where pcode=?");
			pstmt.setString(1, pb.getPRICE());

			pstmt.setString(2, pb.getPQTY());
			pstmt.setString(3, pb.getPCODE());
			rowCount=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	return rowCount;

}
}
