package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.TreeSet;

public class jdbc_pro3 {
	
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
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	void insertData()
	{
		try {
			Connection con=connect();
			Statement stmt=con.createStatement();
			System.out.println("ENTER EMPLOYEE ID");
			String emp_id=sc.nextLine();
			
			System.out.println("ENTER EMPLOYEE firstName:");
			String emp_fname=sc.nextLine();
			
			System.out.println("ENTER EMPLOYEE lastName:");
			String emp_lname=sc.nextLine();
			
			System.out.println("ENTER EMPLOYEE ID");
			String emp_sal=sc.nextLine();
			
			System.out.println("ENTER EMPLOYEE ID");
			String emp_addr=sc.nextLine();
			
			int rowCount=stmt.executeUpdate(insert into employee value('"+emp_id+"','"+emp_fname+"',))
			
			
			
			
			
			
			
			
			
			System.out.println("ENTER EMPLOYEE ID");
			String emp_id=sc.nextLine();
			
			


		}
	}
	String sqlQuery1="insert into employee values('109','vedans','akshara',6000,'elr')";
	String sqlQuery2="select * from employee";
	String sqlQuery3="select * from employee where empid='108'";
	String sqlQuery4="update employee set empsal='9000' where empid='108'";
	String sqlQuery5="delete from employee where where empid='108' ";
	
	public void getData()
	{
		System.out.println("Retrieving the data from employee table");
		
		try
		{
			
			
			String sqlQuery;
			ResultSet rs=stmt.executeQuery(sqlQuery);
			
			TreeSet<Object> ts=new TreeSet<Object>();
			
			
		}
	


	public static void main(String[] args) {

	}

}
