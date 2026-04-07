package com.pack1;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.BLOB;

public class jdbc_pro13 {
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123"
	sqlQuery1="insert into mydata values(?,?)";
	sqlQuery2="select pic_data from mydata where id=?";
	
	
	sqlQuery3="insert into mydata2 values(?,?)";
	sqlQuery4="select file_data from mydata2 where id=?";
	
	
	Connection connect()
	{
		Connection con=null;
		try {
			Class.forName(driver);
			DriverManager.getConnection(db_url,db_uname,db_pwd);
			System.out.println("CONNECTION CREATED");
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return con;
	}
	void meth1() {
		System.out.println("PASSING BLOB DATA INTO DATABASE");
		try {
			Connection con=connect();
			PreparedStatement pstmt=con.prepareStatement(sqlQuery1);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
	void meth2() {
		System.out.println("RETRIEVE BLOB DATA FROMTHE DATABASE");
		try {
			Connection con=connect();
		PreparedStatement pstmt=con.prepareStatement(sqlQuery2);
		pstmt.setString(1, "101");
		ResultSet rs=pstmt.executeQuery();
		if (rs.next())
		{
			BLOB b=rs.getBlob(1);
			byte arr[]=b.getBytes(1,(int)b.length());
			FileOutputStream fos=new FileOutputStream("");
			fos.write(arr);
			fos.close();
			System.out.println("IMAGE RETRIEVED");
		}
		else
		{
			System.out.println("there is no record");
		}

			
		}catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
	}
	
	void meth3() {
		System.out.println("");
		try {
			Connection con=connect();
			PreparedStatement pstmt=con.prepareStatement(sqlQuery3);
			pstmt.setString(1, "101");
			
			
			pstmt.setclob(2,new FileReader(""));
			int rowcount=pstmt.executeupdate();
			if (rowCount==0)
				throw new SQLException();
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		jdbc_pro13 obj=new jdbc_pro13();
		obj.connect();
		obj.meth1();
		obj.meth2();
		
	}

}
