package com.pack1;

import java.sql.Connection;
public class jdbc_pro011 {
		private String driver = "oracle.jdbc.OracleDriver";
	    private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    private String db_uname = "mydb11am";
	    private String db_pwd = "123";

	    ConnectionPool cp=new ConnectionPool(driver,db_url,db_uname,db_pwd);
	    void meth1()
	    {
	    	System.out.println("CALLING CON_INITIALIZATION()");
	    	cp.con_initialization();
	    	System.out.println("REMAINING CONNECTION OBJECTS :"+cp.v.size());
	    	System.out.println("\n***********user1************");
	    	Connection con1=cp.con_acqusition();
	    	System.out.println("REMAINING CONNECTION OBJECTS:"+cp.v.size());
	    	System.out.println("\n***************USER2*************");
	    	Connection con2=cp.con_acqusition();
	    	System.out.println("REMAINING CONNECTION OBJECTS:"+cp.v.size());
	    	
	    	System.out.println("\n***************USER3*************");
	    	Connection con3=cp.con_acqusition();
	    	System.out.println("REMAINING CONNECTION OBJECTS:"+cp.v.size());
	    	

	    	
	    	System.out.println("===============");
	    	cp.con_return(con1);
	    	cp.con_return(con2);
	    	cp.con_return(con3);
	    	
	    }
	    public static void main(String[] args) {
			new jdbc_pro011().meth1();
		}

}

