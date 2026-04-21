package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ProductBean;


public class ViewProductDAO
{
	public ArrayList<ProductBean> a1=new ArrayList<ProductBean>();
	public ArrayList<ProductBean> reteriveEmpData()
	{
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select*from product");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
			ProductBean eb=new ProductBean();
			eb.setpcode(rs.getString(1));
			eb.setpname(rs.getString(2));
			eb.setpcompany(rs.getString(3));
			eb.setpprice(rs.getInt(4));
			eb.setpqty(rs.getString(5));
			a1.add(eb);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return a1;
	}

}

