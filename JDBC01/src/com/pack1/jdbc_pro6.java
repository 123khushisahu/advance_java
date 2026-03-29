package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_pro6 {
	private String driver = "oracle.jdbc.OracleDriver";
	private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname = "mydb11am";
	private String db_pwd = "123";

	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(db_url, db_uname, db_pwd);
			System.out.println("CONNECTION CREATED");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;

	}

	void meth1()
	{
			System.out.println("implementing scrollable ResultSet ==>Readonly\n");
			Connection con=connect();
			try
			{
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery("select*from employee");
			
		    	while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				System.out.println("==================================================================");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			}
	void meth2() {
		System.out.println("implementing scrollable ResultSet ==>updatable\n");
		Connection con = connect();
		try {
			Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2 = stmt2.executeQuery("select*from employee");

			rs2.absolute(1);
			System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " "
					+ rs2.getString(4) + " " + rs2.getString(5));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		jdbc_pro6 obj = new jdbc_pro6();
		obj.meth2();

	}

}
