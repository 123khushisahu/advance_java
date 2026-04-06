package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
	private String driver,db_url,db_uname,db_pwd;
	Vector<Connection> v=new Vector<Connection>();
	public ConnectionPool(String driver,String db_url,String db_uname,String db_pwd)
	{
		this.driver=driver;
		this.db_url=db_url;
		this.db_uname=db_uname;
		this.db_pwd=db_pwd;
	}	
	void con_initialization()
	{
		System.out.println("creating '5' connection obj");
		System.out.println("connection poolis emty");
		
		while(v.size()<5)
		{
			try {
				Class.forName(driver);
				Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
				v.addElement(con);
				
				
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		for(Object o :v)
			System.out.println(o);
		System.out.println("\n'5'connection obj is present in the pool");
	}
	Connection con_acqusition()
	{
		System.out.println("assigning the coonnection obj");
		Connection con=v.elementAt(0);
		v.remove(0);
		return con;
		
	}
	void con_return(Connection con)
	{
		System.out.println("RETURNING A CONNECTION OBJ");
		v.addElement(con);
		for(Object o:v)
			System.out.println(o);
		
	}
	

}
