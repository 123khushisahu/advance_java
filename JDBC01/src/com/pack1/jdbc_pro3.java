package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_pro3 {

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    void insertData() {
        try {
            Connection con = connect();
            Statement stmt = con.createStatement();

            System.out.println("ENTER EMPLOYEE ID:");
            String emp_id = sc.nextLine();

            System.out.println("ENTER FIRST NAME:");
            String emp_fname = sc.nextLine();

            System.out.println("ENTER LAST NAME:");
            String emp_lname = sc.nextLine();

            System.out.println("ENTER SALARY:");
            String emp_sal = sc.nextLine();

            System.out.println("ENTER ADDRESS:");
            String emp_addr = sc.nextLine();

            String query = "insert into employee values('" + emp_id + "','" 
                    + emp_fname + "','" + emp_lname + "'," 
                    + emp_sal + ",'" + emp_addr + "')";

            int rowCount = stmt.executeUpdate(query);

            System.out.println("Inserted rows: " + rowCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        System.out.println("Retrieving data...");

        try {
            Connection con = connect();
            Statement stmt = con.createStatement();

            String sqlQuery = "select * from employee";

            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getInt(4) + " " +
                        rs.getString(5)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jdbc_pro3 obj = new jdbc_pro3();
        obj.insertData();
        obj.getData();
    }
}