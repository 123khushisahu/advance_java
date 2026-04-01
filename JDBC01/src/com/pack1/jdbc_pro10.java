package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc_pro10 {
	private String driver = "oracle.jdbc.OracleDriver";
	private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname = "mydb11am";
	private String db_pwd = "123";

	Scanner sc=new Scanner(System.in);
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			//System.out.println("driver loaded successfully...");
			con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			System.out.println("connection created");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;

	}
	
	public void meth1() throws SQLException
	{
		
		Connection con=connect();
		System.out.println("plz insert data....!");
		
		
		
		System.out.println("Enter Employee name::");
		String ENAME = sc.nextLine();
		
		System.out.println("Enter Employee password::");
		String PWORD=sc.nextLine();
		
		System.out.println("ENTER EMPLOYEE FIRSTNAME::");
		String FNAME=sc.nextLine();
		
		System.out.println("ENTER EMPLOYEE LASTNAME::");
		String LNAME=sc.nextLine();
		
		System.out.println("ENTER EMPLOYEE ADDRESS::");
		String ADDR=sc.nextLine();
		
		System.out.println("ENTER EMPLOYEE MAILID::");
		String MID=sc.nextLine();
		//sc.nextLine();
		
		System.out.println("enter employee phonenumber::");
		Integer PHN=sc.nextInt();
		
		
		 // ✅ PreparedStatement for INSERT
        String query = "insert into employeeResistration values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1,ENAME);
        ps.setString(2, PWORD);
        ps.setString(3, FNAME);
        ps.setString(4, LNAME);
        ps.setString(5, ADDR);
        ps.setString(6,MID);
        ps.setInt(7,PHN);
        
        

//        int rows = ps.executeUpdate();
//        System.out.println(rows + " record inserted");
		
		System.out.println("DATA INSERTED::");
		
		

		
		}	
		
	
		

	public static void main(String[] args) throws SQLException {
		jdbc_pro10 obj = new jdbc_pro10();
		obj.connect();
		obj.meth1();

	}

}
