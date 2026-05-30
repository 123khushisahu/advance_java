package com.DAO;

	import java.sql.Connection;
import java.sql.DriverManager;

	public class DBConnection {
	static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb11am","123");
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				return con;

	}
}

	