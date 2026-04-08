package com.pack1;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class jdbc_pro14 {
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123";
	Scanner sc=new Scanner(System.in);
	void meth1() {
		System.out.println("IMPLEMENTING BATCH PROCCESSING");
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
			System.out.println("CONNECTION CREATED");
			Statement stmt=con.createStatement();
			System.out.println("HOW MANY QUERIES U WANT TO EXECUTE");
			int no_queries=Integer.parseInt(sc.nextLine());
			
			for(int i=1;i<=no_queries;i++) {
				System.out.println("ENTER"+i+"QUERY");
				stmt.addBatch(sc.nextLine());
				System.out.println("ALL"+no_queries+"QUERIES ADDED");
				int arr[]=stmt.executeBatch();
				System.out.println("==============>:");
				for(int data:arr)
				System.out.println(data+" ");
				stmt.clearBatch();
				
			
					
			}
		
			
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		jdbc_pro14 obj=new jdbc_pro14();
		obj.meth1();
	}

}
