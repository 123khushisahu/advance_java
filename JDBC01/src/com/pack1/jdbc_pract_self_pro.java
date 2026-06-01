package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_pract_self_pro {

   private String driver="oracle.jdbc.OracleDriver";
   private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
   private String db_uname="mydb11am";
   private String db_pwd="123";
   Scanner scn=new Scanner(System.in);
   
   Connection connect()
   {
       Connection con=null;
       try
       {
           Class.forName(driver);
           con=DriverManager.getConnection(db_url, db_uname, db_pwd);
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }        
       return con;
   }
   
   void insertData()
    {
    try {
   
    Connection con=connect();
    Statement stmt=con.createStatement();
   
    System.out.println("Enter Employee Id:");
    String emp_id=scn.nextLine();
    System.out.println("Enter Employee FirstName:");
    String emp_fname=scn.nextLine();
    System.out.println("Enter Employee LastName:");
    String emp_lname=scn.nextLine();
    System.out.println("Enter Employee Salary:");
    int emp_sal=Integer.parseInt(scn.nextLine());
    System.out.println("Enter Employee Address:");
    String emp_addr=scn.nextLine();
   
    int rowCount=stmt.executeUpdate("insert into employee values('"+emp_id+"','"+emp_fname+"','"+emp_lname+"',"+emp_sal+",'"+emp_addr+"')");
    if(rowCount == 1) { System.out.println("Data Updated");
    System.out.println("Do you want to view the data : Y/N");
               char choice=scn.nextLine().charAt(0);
               switch(choice)
               {
               case 'Y','y':
                   getData();
                   break;
               case 'N','n':
                   System.out.println("Thank you for updating the data !!!");
                   break;
                   default: System.out.println("Invalid data !!! ");
               }
    }
               else
                   System.out.println("Data NOT updated!!!");
       con.close();
    }
    catch(SQLIntegrityConstraintViolationException sicve) {
    System.out.println("Duplicate Employee Id's are not allowed");
    insertData();
    }
    catch(Exception e) { e.printStackTrace(); }
    }
   public void getData() {
           System.out.println("Retrieving all the data from employee table\n");
           try {
                   Connection con=connect();
               Statement stmt=con.createStatement();
               ResultSet rs=stmt.executeQuery("select * from employee");
               while(rs.next()) {
                   System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
               }
               con.close();
           }
           catch(Exception e) {
               e.printStackTrace();
           }
       }
   public void getDataById()
   {
    try {
        Connection con=connect();
               Statement stmt=con.createStatement();
               
    System.out.println("Enter Employee Id to fetch:");
    String id = scn.nextLine();
    ResultSet rs=stmt.executeQuery("select * from employee where eid='"+id+"'");
    if(rs.next()) {
    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
    }
    con.close();
    } catch(Exception e) { e.printStackTrace(); }
    }
   void updateSal()
   {
    try {
        Connection con=connect();
               Statement stmt=con.createStatement();
    System.out.println("Enter Employee Id to update salary:");
    String id=scn.nextLine();
    System.out.println("Enter New Salary:");
    int sal=Integer.parseInt(scn.nextLine());
   
    int rowCount=stmt.executeUpdate("update employee set esal="+sal+" where eid='"+id+"'");
    if(rowCount == 1)
       System.out.println("Salary Updated");
    con.close();
    } catch(Exception e) {
       e.printStackTrace();
       }
    }
   void deleteData() {
    try {
        Connection con=connect();
               Statement stmt=con.createStatement();
    System.out.println("Enter Employee Id to delete:");
    String id=scn.nextLine();
   
    int rowCount=stmt.executeUpdate("delete from employee where eid='"+id+"'");
    if(rowCount == 1)
       System.out.println("Record Deleted");
    con.close();
    } catch(Exception e) {
       e.printStackTrace();
       }
    }
   public static void main(String[] args)
   {
	   jdbc_pract_self_pro obj=new jdbc_pract_self_pro();
       obj.insertData();
       //obj.getData();
       //obj.getDataById();
       //obj.updateSal();
       //obj.deleteData();
   }
}


