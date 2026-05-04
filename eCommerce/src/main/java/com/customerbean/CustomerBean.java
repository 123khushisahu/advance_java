package com.customerbean;

import java.io.Serializable;

public class CustomerBean implements Serializable{
	private String c_uname,c_pword,c_fname,c_lname,c_addr,c_mid,c_phno;

	public String getC_uname() {
		return c_uname;
	}

	public String getC_pword() {
		return c_pword;
	}

	public String getC_fname() {
		return c_fname;
	}

	public String getC_lname() {
		return c_lname;
	}

	public String getC_addr() {
		return c_addr;
	}

	public String getC_mid() {
		return c_mid;
	}

	public String getC_phno() {
		return c_phno;
	}

	public void setC_uname(String c_uname) {
		this.c_uname = c_uname;
	}

	public void setC_pword(String c_pword) {
		this.c_pword = c_pword;
	}

	public void setC_fname(String c_fname) {
		this.c_fname = c_fname;
	}

	public void setC_lname(String c_lname) {
		this.c_lname = c_lname;
	}

	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}

	public void setC_mid(String c_mid) {
		this.c_mid = c_mid;
	}

	public void setC_phno(String c_phno) {
		this.c_phno = c_phno;
	}
	public CustomerBean(){
		
	}
	

}
