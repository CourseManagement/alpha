package com.DataLayer.CountManagementModule;

import net.sf.json.JSONObject;
import com.DataLayer.Runnable.fixThread;

public class fixClass {
	private static String urlString = "http://test.micromi.net/service/userInfoUpdate.php";
	private String flag;
	private JSONObject jsonObject;
	private String return_flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public JSONObject getjsonObject() {
		return jsonObject;
	}
	public void setjsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public String getReturn_flag() {
		return return_flag;
	}

	public void setReturn_flag(String return_flag) {
		this.return_flag = return_flag;
	}

	public void doComfirm() {
		return_flag = null;
		fixThread thread = new fixThread();
		thread.setFlag(flag);
		thread.setJsonObject(jsonObject);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return_flag = thread.getReturn_flag();
	}
}
