package com.DataLayer.CountManagementModule;

import com.DataLayer.Runnable.loginThread;



public class loginClass {
	private static String urlString = "http://test.micromi.net/service/login.php";
	private String username;
	private String pswd;
	private String result;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void doComfirm() {
		result = "";
		loginThread thread = new loginThread();
		thread.setUsername(username);
		thread.setPswd(pswd);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = thread.getResult();
	}
}
