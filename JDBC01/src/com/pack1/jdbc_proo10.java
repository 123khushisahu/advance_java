package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class jdbc_proo10 {

		private String driver="oracle.jdbc.OracleDriver";
		private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
		private String db_uname="mydb11am";
		private String db_pwd="123";
		
		String  sqlQuery1="update trainseatavailability set AVAILABLE_SEAT=AVAILABLE_SEAT-1 where TRAIN_ID=? and journey_date =? and class=?";
		String  sqlQuery2="insert into bookingdetails values(?,?,?,?,?)";
		String  sqlQuery3="select  PAYMENT_STATUS from customerpayment where customer_id=?";
		String  sqlQuery4="update bookingdetails set status='confirmed' where customer_id=?";
		public void meth1()
		{
			System.out.println("implementing transaction management:");
			try {
				Class.forName(driver);
				Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
				System.out.println("CONNECTION CREATED");
				System.out.println("getAutoCommit() :"+con.getAutoCommit());
				con.setAutoCommit(false);
		System.out.println("getAutoCommit() :"+con.getAutoCommit());

				PreparedStatement pstmt1=con.prepareStatement(sqlQuery1);
				pstmt1.setString(1, "12345");
				pstmt1.setString(2, "2024-10-10");
				pstmt1.setString(3, "sleeper");
				int rowCount1=pstmt1.executeUpdate();
				if(rowCount1==0)
					throw new SQLException("seat are not available!!!");
				System.out.println("SEAT IS LOCKED");
				Savepoint sp=con.setSavepoint();
				
				//================================================
				
				
				
				
				PreparedStatement pstmt2=con.prepareStatement(sqlQuery2);
				pstmt2.setString(1,"b101");
				pstmt2.setString(2,"12345");
				pstmt2.setString(3,"c123");
				pstmt2.setInt(4,1);
				pstmt2.setString(5,"payment pending");
				int rowCount2=pstmt2.executeUpdate();
				if(rowCount2==0)
					throw new SQLException("booking not confirmed");
				System.out.println("BOOKING RECORD INSERT SUCCESFULLY!!!");
				System.out.println("awaiting for payment confirmation!!!");
				
				
				
				
				//================================================
				
				
				
				
				
				
				PreparedStatement pstmt3=con.prepareStatement(sqlQuery3);
				pstmt3.setString(1, "c123");
				ResultSet rs1=pstmt3.executeQuery();
				String status="failed";
				if(rs1.next())
				{
					status=rs1.getString(1);
				}
				if(status.equals("success"))
				{
					PreparedStatement pstmt4=con.prepareStatement(sqlQuery4);
					pstmt4.setString(1,"c123");
					int rowCount4=pstmt4.executeUpdate();
					if(rowCount4==0)
						throw new SQLException("transaction terminated due to server side problem");
						con.commit();
						System.out.println("seat booked successfully");
						System.out.println("transaction done!!!");
						System.out.println("all savepoint release");

				}
				else
				{
					System.out.println("payment not done");
					System.out.println("rolling back to the last savepoint");
					con.rollback(sp);				
				}	
				
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		public static void main(String[] args) {

		new jdbc_proo10().meth1();
	}

}
