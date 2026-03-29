
package com.pack1;
import java.sql.*;
import java.util.Scanner;

public class jdbc_pro4 {
    private String driver="oracle.jdbc.OracleDriver";
    private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
    private String db_uname="mydb11am";
    private String db_pwd="123";

    public void Connect() {
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(db_url, db_uname, db_pwd);

            Statement st = con.createStatement();
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter BOOKID: ");
            int bookid = sc.nextInt();

            System.out.println("Enter BOOKName: ");
            String bname = sc.next();

            System.out.println("Enter AUTHOR: ");
            String author = sc.next();

            System.out.println("Enter genere: ");
            String genere = sc.next();

            System.out.print("Enter bookcost: ");
            int bcost = sc.nextInt();

            // INSERT
            String query = "INSERT INTO library VALUES("
                    + bookid + ", '" + bname + "', '" + author + "', '"
                    + genere + "', " + bcost + ")";

            int i = st.executeUpdate(query);

            if (i > 0) {
                System.out.println("Data Inserted Successfully");
            }

            // SELECT
            String query1 = "select * from library";
            PreparedStatement pstm = con.prepareStatement(query1);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4) + " " +
                        rs.getInt(5));
            }

            // DELETE
            String query2 = "delete from library where bookid=1";
            pstm.executeUpdate(query2);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new jdbc_pro4().Connect();
    }
}