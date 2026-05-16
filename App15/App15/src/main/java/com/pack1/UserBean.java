package com.pack1;

import java.io.Serializable;

public class UserBean implements Serializable {
	private String u_uname, u_pwd, u_fname, u_lname, u_mailid, u_phone;

	public String getU_uname() {
		return u_uname;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public String getU_fname() {
		return u_fname;
	}

	public String getU_lname() {
		return u_lname;
	}

	public String getU_mailid() {
		return u_mailid;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_uname(String u_uname) {
		this.u_uname = u_uname;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}

	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}

	public void setU_mailid(String u_mailid) {
		this.u_mailid = u_mailid;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	UserBean(){
		
	}

}
