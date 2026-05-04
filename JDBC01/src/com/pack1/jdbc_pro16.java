package com.pack1;
import java.sql.*;

public class jdbc_pro16 {

	    public static void main(String[] args) {
	        try {
	            Connection con = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521:orcl","mydb11am","123");
	            System.out.println("CONNECTION CREATED!!!");
	            // Disable auto-commit
	            con.setAutoCommit(true);

	            PreparedStatement ps1 = con.prepareStatement(
	                "UPDATE employee SET esal = esal - 100 WHERE EID = '107'");

	            PreparedStatement ps2 = con.prepareStatement(
	                "UPDATE employee SET esal = esal + 1000 WHERE EID = '1'");

	            ps1.executeUpdate();
	            ps2.executeUpdate();

	            // Commit transaction
	           // con.commit();

	            System.out.println("Transaction Successful");

	        } catch (Exception e) {
	            try {    //nested try catch block
	                // Rollback on error
	            	//0con.rollback();
	                System.out.println("Transaction Failed - Rolled Back");
	            } catch (Exception ex) {
	                System.out.println(ex);
	            }
	        }
	    }
	}


