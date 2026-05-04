package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ProductBean;


public class ViewProductDAO {
		 ArrayList<ProductBean> a1=new ArrayList<ProductBean>();
		public ArrayList<ProductBean> reteriveProductInfo()
		{
			try {
				Connection con=DBConnect.getCon();
				PreparedStatement pstmt=con.prepareStatement("select*from product1");
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
				ProductBean pb=new ProductBean();
				pb.setPCODE(rs.getString(1));
				pb.setPNAME(rs.getString(2));
				pb.setPCOMPANY(rs.getString(3));
				pb.setPRICE(rs.getString(4));
				pb.setPQTY(rs.getString(5));
				a1.add(pb);
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return a1;
		}

	}




