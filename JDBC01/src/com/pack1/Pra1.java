package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class Pra1 {
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123";
	public void connection() {
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);

			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select*from employee");
			System.out.println("connection created");

			
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			
			
			con.close();
			
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		Pra1 a1=new Pra1();
		a1.connection();
	}

}
