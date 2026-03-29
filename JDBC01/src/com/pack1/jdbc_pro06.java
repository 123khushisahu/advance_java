package com.pack1;

import java.sql.*;
import java.util.Scanner;

public class jdbc_pro06 {

    private String driver = "oracle.jdbc.OracleDriver";
    private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String db_uname = "mydb11am";
    private String db_pwd = "123";

    public void connect() {
        System.out.println("CONNECTING JAVA PROGRAM TO DATABASE");

        try {
            // 1. Load driver
            Class.forName(driver);

            // 2. Connection
            Connection con = DriverManager.getConnection(db_url, db_uname, db_pwd);

            System.out.println("Connection created");

            Scanner sc = new Scanner(System.in);

            // Input
            System.out.println("Enter employee id:");
            String id = sc.next();

            System.out.println("Enter employee fname:");
            String fname = sc.next();

            System.out.println("Enter employee lname:");
            String lname = sc.next();

            System.out.println("Enter employee salary:");
            int salary = sc.nextInt();

            System.out.println("Enter employee address:");
            String add = sc.next();

            // ✅ PreparedStatement for INSERT
            String query = "insert into employee values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, id);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setInt(4, salary);
            ps.setString(5, add);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted");

            // ✅ SELECT
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");

            System.out.println("\nEmployee Data:\n");

            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getInt(4) + " " +
                        rs.getString(5)
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jdbc_pro06 obj = new jdbc_pro06();
        obj.connect();
    }
}