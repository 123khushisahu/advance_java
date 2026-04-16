package com.pack1;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class jdbc_pro7 {
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String db_url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String db_uname = "mydb11am";
	private String db_pwd = "123";
	
	public void meth1()
	{
		System.out.println("IMPLEMENTING ROWSET INTERFACE\n");
		
		try {
			RowSetFactory rsf=RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl(db_url);
			jrs.setUsername(db_uname);
			jrs.setPassword(db_pwd);
			jrs.setCommand("select*from employee");
			jrs.execute();
			
			//jrs.close();its generate exception
			
			while(jrs.next())
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(4));
			System.out.println("=====================");
			
			jrs.absolute(-2);
			System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(4));
			System.out.println("=====================");
			jrs.afterLast();
			while(jrs.previous())
				System.out.println(jrs.getString(1)+" "+jrs.getString(2)+" "+jrs.getString(4));

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void meth2()
	{
		System.out.println("IMPLEMENTING ROWSET INTERFACE\n");
		try
		{
			RowSetFactory rsf=RowSetProvider.newFactory();
			CachedRowSet crs=rsf.createCachedRowSet();
			crs.setUrl(db_url );
			crs.setUsername(db_uname );
			crs.setPassword(db_pwd);
			crs.setCommand("select eid,efname,esal from employee ");
			crs.execute();
			while(crs.next())
			{
				String id=crs.getNString(1);
				if(id.equals("108"))
				{
					crs.updateInt("esal", 75000);
					crs.updateRow();
					System.out.println("DATA UPDATED");
				}
			}
		//crs.acceptChanges();
		crs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		jdbc_7	obj=new jdbc_7();
		//obj.meth1();
		obj.meth2();
		

	}

}
