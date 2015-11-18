package com.DataLayer.CountManagementModule;

import com.DataLayer.Runnable.queryThread;
import net.sf.json.JSONObject;

public class queryClass {
	private static String urlString = "http://test.micromi.net/service/userInfo.php";
	private String flag;
	private String user_name;
	private String return_flag;
	private JSONObject return_arr;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReturn_flag() {
		return return_flag;
	}
	public void setReturn_flag(String return_flag) {
		this.return_flag = return_flag;
	}
	public JSONObject getReturn_arr() {
		return return_arr;
	}
	public void setReturn_arr(JSONObject return_arr) {
		this.return_arr = return_arr;
	}
	public void doComfirm() {
		return_flag = null;
		return_arr = null;
		queryThread thread = new queryThread();
        thread.setFlag(flag);
        thread.setUser_name(user_name);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return_flag = thread.getReturn_flag();
		return_arr = thread.getReturn_arr();
	}
}
