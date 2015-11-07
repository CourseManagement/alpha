package com.DataLayer.Model;

public class departmentmanager {
	private String user_name;
	private String password;
	private String department;
    public departmentmanager() {
		// TODO Auto-generated constructor stub
    	super();
	} 
	public departmentmanager(String user_name, String password,String department) {
	super();
	this.user_name=user_name;
	this.password=password;
	this.department=department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
