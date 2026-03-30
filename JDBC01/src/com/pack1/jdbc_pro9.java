package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class jdbc_pro9 {
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123";
	Scanner sc=new Scanner(System.in);
	
	Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
             con = DriverManager.getConnection(db_url, db_uname, db_pwd);
             System.out.println("CONNECTION CREATED");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1(){
		CallableStatement cstmt = con.prepareCall("{call reteriveData(?,?,?,?,?,?,?)}");

		System.out.println("implementing prepare statement");
		Connection con=connect();
		try
		{
			System.out.println("ENTER ENAME:");
			String e_ename=sc.nextLine();

			System.out.println("ENTER pword:");
			String e_pword=sc.nextLine();
			

			System.out.println("ENTER fname:");
			String e_fname=sc.nextLine();
			

			System.out.println("ENTER lname:");
			String e_lname=sc.nextLine();
			

			System.out.println("ENTER addr:");
			String e_addr=sc.nextLine();
			

			System.out.println("ENTER mailid:");
			String e_mid=sc.nextLine();
			

			System.out.println("ENTER phoneno:");
			String e_phN=sc.nextLine();
			
			
			
			System.out.println("data inserted");
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
       jdbc_pro9 obj=new jdbc_pro9();
       obj.connect();
       obj.meth1();
       

		// TODO Auto-generated method stub

	}

}
