package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.util.Scanner;

public class Transaction {
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123";
	
	Scanner sc=new Scanner(System.in);
	Connection connect() {
		 Connection con=null;
		try {
			
			Class.forName(driver);
		    con=DriverManager.getConnection(db_url, db_uname, db_pwd);
			System.out.println("connection created");

		}catch (Exception e)
		{
			e.printStackTrace();
			
		}
			return con;
		}
	
	void meth1() {
		Connection con=null;
		

		try {
			con=connect();
			con.setAutoCommit(false);
		PreparedStatement debit=con.prepareStatement("update bankAccount set balance=balance-? where ACC_NO=?");
		debit.setInt(1, 1000);
		debit.setInt(2, 101);
		debit.executeUpdate();
		System.out.println("₹1000 deducted from Alice");
		Savepoint sp = con.setSavepoint("AfterDebit");
		
		PreparedStatement credit = con.prepareStatement(
			    "UPDATE bankAccount SET balance = balance + ? WHERE acc_no = ?"
			);

			credit.setInt(1, 1000);
			credit.setInt(2, 102);

			// Simulate error (for testing)
			if(true) {
			    throw new Exception("Error while crediting................");
			}

			credit.executeUpdate();
			System.out.println("₹1000 credited to Bob");
			
			//commit if everything is successful
			con.commit();
			System.out.println("TRANSACTION IS SUCCESSFULLY DONE");
			
//		System.out.println("getAutoCommit() :"+con.getAutoCommit());
//		con.setAutoCommit(false);
		}catch (Exception e) {
			try {
				System.out.println("error occurred,rolling back....");
				con.rollback();
			}catch (Exception ex) {
				ex.printStackTrace();
				// TODO: handle exception
			}
		e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}	
	public static void main(String[] args) {
		Transaction obj=new Transaction();
		obj.connect();
		obj.meth1();

	}

}
