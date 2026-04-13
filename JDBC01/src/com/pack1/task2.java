package com.pack1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class task2 {
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
	    
	    public void displayfooIteams() throws SQLException {
			// TODO Auto-generated method stub
	    	
	    	String sql ="selct * from food";
	    	
	    	Statement stm= con.createStatement();
	    	
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        task2  obj = new task2();
          obj.connect();
        Scanner s = new Scanner(System.in);
        
         while(true) {
        	 
        	 System.out.println("\n 1.show All food Item");
               System.out.println("2. Place Order");
               System.out.println("3. View Orders");
               System.out.println("4. Exit");
               int c =s.nextInt();
            
        	 switch (c) {
			case 1: 
				 obj.displayOrder() ;
				    break;
				   
			 case 2:
                 System.exit(0);
                 break;
             default:
                 System.out.println("Invalid choice");
                 System.out.println("HEY");
			}
        	 
        	 
         }
        

	}

	

}
