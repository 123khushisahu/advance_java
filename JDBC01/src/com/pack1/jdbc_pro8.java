package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
<<<<<<< HEAD
import java.sql.Types;
=======
>>>>>>> bf8a41d2708c30ceb9feced3627cedae5f2a8bf8
import java.util.Scanner;

public class jdbc_pro8 {
	
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
			con=DriverManager.getConnection(db_url,db_uname,db_pwd);
			System.out.println("connection created succesfully");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	void meth1()
	{
		System.out.println("implementing callable statement===>procedure");
		Connection con=connect();
		try
		{
			CallableStatement csmt=con.prepareCall("{call InsertEmpData(?,?,?,?,?)}");
			System.out.println("enter employee id");
			String e_id=sc.nextLine();
			System.out.println("enter employee name");
			String e_name=sc.nextLine();
			System.out.println("enter employee desg");
			String e_desg=sc.nextLine();
			System.out.println("enter employee basic salary");
			int e_bsal=Integer.parseInt(sc.nextLine());
			float e_tsal=(float)(e_bsal+(0.45*e_bsal)+(0.25*e_bsal));
			
			csmt.setString(1, e_id);
			csmt.setString(2, e_name);
			csmt.setString(3, e_desg);
			csmt.setInt(4, e_bsal);
			csmt.setFloat(5, e_tsal);
			
			csmt.execute();
			System.out.println("data inserted");
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	void meth2()
	{
<<<<<<< HEAD
		System.out.println("implementing callable statement===>procedure2");
		Connection con=connect();
		try {
			CallableStatement cstmt = con.prepareCall("{call retrieveData(?,?,?,?,?)}");
			System.out.println("enter employee id");
			String e_id=sc.nextLine();
			cstmt.setString(1, e_id);
			
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.registerOutParameter(5, Types.FLOAT);
			
			cstmt.execute();
			
			System.out.println("*************employee data********************");
			System.out.println("EMPLOYEE ID:"+e_id);
			System.out.println("EMPLOYEE NAME:"+cstmt.getString(2));
			System.out.println("EMPLOYEE DESIGNATION:"+cstmt.getString(3));
			System.out.println("EMPLOYEE BASIC SALARY:"+cstmt.getInt(4));
			System.out.println("EMPLOYEE TOTAL SALARY:"+cstmt.getFloat(5));
			
=======
		System.out.println("i want to execute query");
		Connection con=connect();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM emp");			
>>>>>>> bf8a41d2708c30ceb9feced3627cedae5f2a8bf8
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return;
	}

	public static void main(String[] args) {
		jdbc_pro8 obj=new jdbc_pro8();
		obj.meth1();
		obj.meth2();
	}

}
