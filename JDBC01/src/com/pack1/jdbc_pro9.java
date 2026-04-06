package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

	public class jdbc_pro9 {
	private String driver = "oracle.jdbc.OracleDriver";
	private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname = "mydb11am";
	private String db_pwd = "123";
	
	Scanner sc = new Scanner(System.in);
	Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(db_url, db_uname, db_pwd);
			System.out.println("CONNECTION CREATED");

			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
	}

	
	void meth1() {

		System.out.println("implementing prepare statement");
		Connection con = connect();
		try {			
			PreparedStatement pstmt = con.prepareStatement("insert into employeeregistration values(?,?,?,?,?,?,?)");
			
			System.out.println("ENTER ENAME:");
			String ename = sc.nextLine();

			System.out.println("ENTER pword:");
			String pword = sc.nextLine();

			System.out.println("ENTER fname:");
			String fname = sc.nextLine();

			System.out.println("ENTER lname:");
			String lname = sc.nextLine();

			System.out.println("ENTER addr:");
			String addr = sc.nextLine();

			System.out.println("ENTER mailid:");
			String mid = sc.nextLine();

			System.out.println("ENTER phoneno:");
			int phN = sc.nextInt();			
			    pstmt.setString(1, ename);
		        pstmt.setString(2, pword);
		        pstmt.setString(3, fname);
		        pstmt.setString(4, lname);
		        pstmt.setString(5, addr);
		        pstmt.setString(6, mid);
		        pstmt.setInt(7, phN);
		        
		        int rows =  pstmt.executeUpdate();
			
					if(rows > 0){
						System.out.println("data inserted successfully.......");
					}
					else
					{
						System.out.println("Data not inserted......");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				public static void main(String[] args) {
				jdbc_pro9 obj = new jdbc_pro9();
				obj.connect();
				obj.meth1();

		// TODO Auto-generated method stub

	}

}
