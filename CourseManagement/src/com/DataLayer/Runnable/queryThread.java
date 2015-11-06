package com.DataLayer.Runnable;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DUtils.HttpRequestUtils;


public class queryThread extends Thread {
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		return_flag = null;
		return_arr = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 添加要传递的参数

		NameValuePair pair1 = new BasicNameValuePair("flag", flag);
		NameValuePair pair2 = new BasicNameValuePair("user_name", user_name);
		params.add(pair1);
		params.add(pair2);
		// params.add(new BasicNameValuePair("par",
		// "HttpClient_android_Post"));
		System.out.println(params.toString());
		JSONObject newJsonObject = HttpRequestUtils.httpPost(urlString, params);
		return_flag = (String) newJsonObject.get("return_flag");
		return_arr=newJsonObject.getJSONObject("result_arr");
	}

}
