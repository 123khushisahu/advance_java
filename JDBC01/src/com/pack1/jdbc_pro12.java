package com.pack1;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSet;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class jdbc_pro12 {
private String driver="oracle.jdbc.OracleDriver";
private String db_url="jdbc:oracle:thin:@localhost:1521:orcl";
private String db_uname="mydb11am";
private String db_pwd="123";

String sqlQuery="select efname,elname fromemployee";
String sqlQuery2="select efname,elname,esal from employee where eid=?";
void meth1() {
	System.out.println("implementing metadata in jdbc\n");
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(db_url,db_uname,db_pwd);
	DatabaseMetaData dbmtdt=con.getMetaData();
	System.out.println("*************databasemetadata****************");
	System.out.println("GETDATABASEPRODUCTNAME()"+dbmtdt.getDatabaseProductName());
	System.out.println("GETDATABASEPRODUCTversion()"+dbmtdt.getDatabaseProductVersion());
	System.out.println("GETDRIVERNAME()"+dbmtdt.getDriverName());
	System.out.println("supportsStoredProcedures()"+dbmtdt.supportsStoredProcedures());
	PreparedStatement pstmt1=con.prepareStatement(sqlQuery2);
	pstmt1.setString(1, "101");
	ResultSet rs=pstmt1.executeQuery();
	
	
	ParameterMetaData pmtdt=pstmt1.getParameterMetaData();
	System.out.println("*************parametermetadata****************");
	System.out.println("getParameterCount()"+pmtdt.getParameterCount());
	System.out.println("getParameterType()"+pmtdt.getParameterType(1));
	System.out.println("getParameterMode()"+pmtdt.getParameterMode(1));
	System.out.println("isNullable()"+pmtdt.isNullable(1));
	
	ResultSetMetaData rsmtdt=rs.getMetaData();
	System.out.println("*************ResultSetMetaData****************");
	System.out.println("getColumnCount()"+rsmtdt.getColumnCount());
	System.out.println("getColumnName()"+rsmtdt.getColumnName(1));
	System.out.println("getColumnDisplaySize()"+rsmtdt.getColumnDisplaySize(1));
	System.out.println("isAutoIncrement()"+rsmtdt.isAutoIncrement(1));
	
	RowSetFactory rsf=RowSetProvider.newFactory();
	CachedRowSet crs=rsf.createCachedRowSet();
	crs.getURL(db_url);
	crs.setUsername(db_uname);
	crs.setPassword(db_pwd);
	crs.setCommand("select eid,efname,esal from employee");
	crs.execute();
	
	RowSetMetaData rowmtdt=(RowSetMetaData)crs.getMetaData();
	System.out.println("*********RowSetMetaData************");
	System.out.println("getColumnCount()"+rowmtdt.getColumnCount());
	System.out.println("getColumnName()"+rowmtdt.getColumnName(1));
	System.out.println("getColumnDisplaySize()"+rowmtdt.getColumnDisplaySize(1));
	System.out.println("isAutoIncrement()"+rowmtdt.isAutoIncrement(1));
		}catch (Exception e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		jdbc_pro12 obj=new jdbc_pro12();
		obj.meth1();
	}

}
