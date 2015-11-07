package com.DataLayer.Model;

public class collegemanager {
	private String user_name;
	private String password;
	private String name;
	private String telephone;
public collegemanager() {
	super();
	// TODO Auto-generated constructor stub
	}
	public collegemanager(String user_name, String password,
	String name, String telephone) {
	super();
	this.user_name=user_name;
	this.password=password;
	this.name=name;
	this.telephone=telephone;
	
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
