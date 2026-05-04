package com.bean;

import java.io.Serializable;

public class Student implements Serializable{


	private int id;
	private String name;
	private String email;
	private String course;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getCourse() {
		return course;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	

}
