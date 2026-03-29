package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc_pro5 {
	private String driver="oracle.jdbc.OracleDriver";
	private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname="mydb11am";
	private String db_pwd="123";
	Scanner sc=new Scanner(System.in);
	
	Connection connect()
	{
		System.out.println("connecting java program to database");
		Connection con=null;

		try
		{
			Class.forName(driver);
			 con=DriverManager.getConnection(db_url,db_uname,db_pwd);
			System.out.println("CONNECTION CREATED");
			
			
		}catch(Exception e)
		{
			System.out.println("DATABASE CONECTION FAILED!!");
			e.printStackTrace();
		}
		return con;
	}
		void patient_operations() {
			
			Connection con=connect();
			try
			{
				PreparedStatement pstmt1=con.prepareStatement("insert into patient values(?,?,?,?)");
				PreparedStatement pstmt2=con.prepareStatement("select * from patient");
				PreparedStatement pstmt3=con.prepareStatement("select * from patient where pid=?");
				PreparedStatement pstmt4=con.prepareStatement("update patient set age=? where pid=?");
				PreparedStatement pstmt5=con.prepareStatement("delete from patient where pid=?");
				
				while(true) {
					System.out.println("\nWELCOME TO PATIENT PORTAL");
					System.out.println("PLZ CHOOSE YOUR OPTION");
					System.out.println("1. ADD PATIENT\n2.view all patients\n3.reterive patient data\n4.update patient data\n5.delete patient data\n6.exit");
					int choice=Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("add patient data");
						
						System.out.println("enter patient id");
						String pat_id1=sc.nextLine();
								
						System.out.println("enter patient name");
						String pat_name=sc.nextLine();
							
						System.out.println("enter patient age");
						int pat_age=Integer.parseInt(sc.nextLine());
						
						System.out.println("enter patient contact");
						long pat_contact=Long.parseLong(sc.nextLine());
						
						pstmt1.setString(1, pat_id1);
						pstmt1.setString(2, pat_name);
						pstmt1.setInt(3, pat_age);
						pstmt1.setLong(4, pat_contact);
						
						
						int rowCount1=pstmt1.executeUpdate();
						
						if(rowCount1>0)
							System.out.println("PATIENT DATA INSERTED\n");
						else
							System.out.println("PATIENT DATA INSERTION FAILED!!!");						
							
						break;
					case 2:
						System.out.println("\nview all patient data");
						ResultSet rs1=pstmt2.executeQuery();
						while(rs1.next())
						{
							System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getLong(4));
						}
						
						
						
						break;
					case 3:
						System.out.println("\nretrieve patient data basing on'PID'");
						System.out.println("ENTER PATIENT ID");
						String p_id=sc.nextLine();
						pstmt3.setString(1, p_id);
						ResultSet rs2=pstmt3.executeQuery();
						if(rs2.next())
							System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getInt(3)+" "+rs2.getLong(4));
						else
							System.out.println("there is no patient record available:"+p_id);
						
						
						
						
						break;
					case 4:
						System.out.println("update patient data basing on'PID'");
						System.out.println("enter patient id");
						String p_id2=sc.nextLine();
						
						System.out.println("ENTER PATIENT AGE");
						int p_age=Integer.parseInt(sc.nextLine());
						
						System.out.println("ENTER PATIENT contact");
						long p_contact=Long.parseLong(sc.nextLine());
						
						pstmt4.setInt(1, p_age);
						pstmt4.setString(2, p_id2);
						pstmt4.setLong(3, p_contact);
						int rowCount2=pstmt4.executeUpdate();
						if(rowCount2>0)
							System.out.println("patient with:"+p_id2+"age has been updatedwith:"+p_age);
						else
							System.out.println("there is no  available with patient id:"+p_id2);

						
						
						/*System.out.println("ENTER PATIENT contact");
						long p_contact=Long.parseLong(sc.nextLine());
						pstmt4.setLong(1, p_contact);
						pstmt4.setString(2, p_id2);
						int rowCount03=pstmt4.executeUpdate();
						if(rowCount03>0)
							System.out.println("patient with:"+p_id2+"contact has been updated with:"+p_contact);
						else
							System.out.println("there is no  available with patient id:"+p_id2);*/

						
							
						break;
					case 5:
						System.out.println("\ndelete patient data basing on'PID'");
						System.out.println("enter patient id");
						String p_id3=sc.nextLine();
						pstmt5.setString(1, p_id3);
						int rowCount3=pstmt5.executeUpdate();
						if(rowCount3>0)
							System.out.println("PATIENT WITH ID:"+ p_id3+"RECORD IS DELETED");
						else
							System.out.println("there is no   patient record available with patient id:"+p_id3);
							
							
			
						break;
					case 6:
						System.out.println("thans for visiting our patient portal");
						System.out.println("see you soon");
						System.exit(0);
						
						
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
		jdbc_pro5 obj=new jdbc_pro5();
			obj.patient_operations();
	}

}
