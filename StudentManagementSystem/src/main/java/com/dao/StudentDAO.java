package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bean.Student;

public class StudentDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "mydb11am",
                "123");

        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }

    // ✔️ public method
    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(
                "insert into students values(student_seq.NEXTVAL, ?, ?, ?)");

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());

            status = ps.executeUpdate();

            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
}