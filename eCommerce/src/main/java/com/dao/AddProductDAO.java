package com.dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import com.bean.ProductBean;//PCODE,PNAME,PCOMPANY,PRICE,PQTY;

	public class AddProductDAO {
		public int insertproduct(ProductBean pb)
		{
			int rowCount=0;
			try {
				Connection con=DBConnect.getCon();
				PreparedStatement pstmt=con.prepareStatement("insert into product1 values(?,?,?,?,?)");
				
				pstmt.setString(1, pb.getPCODE());
				pstmt.setString(2, pb.getPNAME());
				pstmt.setString(3, pb.getPCOMPANY());
				pstmt.setString(4, pb.getPRICE());		
				pstmt.setString(5, pb.getPQTY());
				rowCount=pstmt.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();		
				}
				return rowCount;
			}

	}



