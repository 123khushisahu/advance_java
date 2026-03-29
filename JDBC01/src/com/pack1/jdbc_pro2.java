package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class jdbc_pro2 {
		private String driver="oracle.jdbc.OracleDriver";
		private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
		private String db_uname="mydb11am";
		private String db_pwd="123";
		String sqlQuery="select * from employee";
		String sqlQuery2="insert into employee values('108','veda','akshara',65000,'elr')";

		Scanner sc=new Scanner(System.in);
		
		public void getData()
		{
			System.out.println("Retrieving the data from employee table");
			
			try
			{
				Class.forName(driver);
				Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sqlQuery);
				
				TreeSet<Object> ts=new TreeSet<Object>();
				
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
					ts.add(rs.getString(1));
					//break;
				}
				System.out.println("BEFORE: "+ts);
				Iterator<Object> i=ts.descendingIterator(); 
				System.out.println("AFTER: ");
				while(i.hasNext())
					System.out.println(i.next()+" ");
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		void insertData()
{
			//System.out.println("INSERTING THE DATA IN TO EMPLOYEE TABLE\n");
			System.out.println("INSERTING THE DATA IN TO EMPLOYEE TABLE\n");
			
			try
			{
				Class.forName(driver);
				Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
				System.out.println("CONNECTION CREATED");
				Statement stmt=con.createStatement();
				int rowCount=stmt.executeUpdate(sqlQuery2);
				
				
				System.out.println("INSER THE DATA INTO EMPLOYEE TABLE");
				
				System.out.println("ENTER EMPLOYEE ID:");
				String EID=sc.nextLine();
				
				System.out.println("ENTER EMPLOYEE first name:");
				String EFNAME=sc.nextLine();


				
				if(rowCount==1)
				{
					System.out.println("DATA UPDATED");
					System.out.println("DO YOU WANT TO VIEW THE DATA:Y/N");
					char choice=sc.nextLine().charAt(0);
					switch(choice)
					{
					case 'Y','y':
						getData();
					break;
					case 'N','n':
						System.out.println("THANKS FOR UPDATING THE DATA!!!");
					break;
					default:System.out.println("INVALID DATA!!!");
					}
				}
				else
					System.out.println("DATA NOT UPDATED!!!");
			}
			catch(SQLIntegrityConstraintViolationException sicve) {
				System.out.println("DUPLICATE EMPLOYEE ID ARE NOT ALLOWED");
				insertData();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		}
	public static void main(String[] args)
	{
		jdbc_pro2 obj=new jdbc_pro2();
		obj.getData();
		obj.insertData();
		
	}

}
