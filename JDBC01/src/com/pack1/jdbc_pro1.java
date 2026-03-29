package com.pack1;


//it is done by sir;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc_pro1 
{
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123";
	
	public void connect()
	{
		System.out.println("connecting java program to database");
		try
		{
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
			System.out.println("connection created");
			con.close();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[]args)
	{
		new jdbc_pro1().connect();
	}

}
