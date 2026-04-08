package com.pack1;

import java.sql.*;
import java.util.Scanner;

public class Jdbc_pro15{

    private String driver = "oracle.jdbc.OracleDriver";
    private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String db_uname = "mydb11am";
    private String db_pwd = "123";

    Connection con;
    Scanner sc = new Scanner(System.in);

    // CONNECT DATABASE
    void connect() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(db_url, db_uname, db_pwd);
            System.out.println("Connected Successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DISPLAY ALL FOOD ITEMS
    void showFood() {
        try {
            String query = "SELECT * FROM food";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("---- FOOD MENU ----");
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                        rs.getString(2) + " | Rs." +
                        rs.getInt(3)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // PLACE ORDER
    void placeOrder() {
        try {
            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();

            System.out.print("Enter Food ID: ");
            int foodId = sc.nextInt();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            // GET PRICE
            String q1 = "SELECT price FROM food WHERE food_id=?";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setInt(1, foodId);
            ResultSet rs = ps1.executeQuery();

            int price = 0;
            if (rs.next()) {
                price = rs.getInt(1);
            }

            int total = price * qty;

            System.out.println("Price: " + price);
            System.out.println("Total Price: " + total);

            // INSERT ORDER
            String q2 = "INSERT INTO orders VALUES(?,?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(q2);

            ps2.setInt(1, orderId);
            ps2.setInt(2, foodId);
            ps2.setInt(3, qty);
            ps2.setInt(4, total);

            ps2.executeUpdate();

            System.out.println("Order Placed Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL ORDERS
    void viewOrders() {
        try {
            String query = "SELECT * FROM orders";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("---- ALL ORDERS ----");
            while (rs.next()) {
                System.out.println(
                        "OrderID: " + rs.getInt(1) +
                        " FoodID: " + rs.getInt(2) +
                        " Qty: " + rs.getInt(3) +
                        " Total: " + rs.getInt(4)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
    	Jdbc_pro15 obj = new Jdbc_pro15();
        obj.connect();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Show Food");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj.showFood();
                    break;
                case 2:
                    obj.placeOrder();
                    break;
                case 3:
                    obj.viewOrders();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    System.out.println("HEY");
            }
        }
    }
}