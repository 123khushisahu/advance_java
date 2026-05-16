package com.pack1;

import java.io.Serializable;

public class UserBean implements Serializable{
	private String userName,userMail,userMob;

	public String getUserName() {
		return userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}
	public UserBean() {
		
	}

}
