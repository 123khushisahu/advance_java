package com.Bean;

public class EmployeePojo {//plain old java object(pojo)
	
	//hi this is crud app
	
	/*Types of Access Modifiers in Java

	There are 4 access modifiers:

	+-----------+-------------+--------------+-----------+---------------+
	| Modifier  | Same Class  | Same Package | Subclass | Other Package |
	+-----------+-------------+--------------+-----------+---------------+
	| private   | ✅          | ❌           | ❌        | ❌            |
	| default   | ✅          | ✅           | ❌        | ❌            |
	| protected | ✅          | ✅           | ✅        | ❌*           |
	| public    | ✅          | ✅           | ✅        | ✅            |
	+-----------+-------------+--------------+-----------+---------------+

	* protected works in other packages only through inheritance.
	
	*/
	
	
	
	//Camel Cases Definition
	
	//In Java, Camel Case is a naming style where words are joined 
	//together without spaces, and some 
	//letters are capital.
	private int id;
	private int emp_id;
	private String empName;
	private String address;
	private String email;
	private long mobNo;
	private String empDept;
	
	//getter & setter
	
	public int getEmp_id() {
		return emp_id;
	}
	public String getEmpName() {
		return empName;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public long getMobNo() {
		return mobNo;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
		
	}
	
	
	
	
	
	
	
	
	

