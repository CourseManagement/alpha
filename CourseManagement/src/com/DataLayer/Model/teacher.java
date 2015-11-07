package com.DataLayer.Model;

public class teacher {
	private String user_name;
	private String password;
	private String name;
	private String email;
	private String telephone;
	private String sex;
	private String birthday;
	
	public teacher() {
		super();
		// TODO Auto-generated constructor stub
		}
		public teacher(String user_name, String password,
		String name, String email, String telephone,String sex,String birthday) {
		super();
		this.user_name = user_name;
		this.password=password;
		this.name=name;
		this.email=email;
		this.telephone=telephone;
		this.sex=sex;
		this.birthday=birthday;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String toString() {
		return "[user_name=" + this.user_name + ", password="
		+ this.password + ", name=" + this.name + ", email="
		+ this.email + ", telephone=" + this.telephone + ", sex=" + this.sex+ ", birthday=" + this.birthday+ "]";
		}

}
