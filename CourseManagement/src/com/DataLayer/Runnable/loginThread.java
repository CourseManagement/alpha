package com.DataLayer.Runnable;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DUtils.HttpRequestUtils;


public class loginThread extends Thread {
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		result = "";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 添加要传递的参数

		NameValuePair pair1 = new BasicNameValuePair("username", username);
		NameValuePair pair2 = new BasicNameValuePair("pswd", pswd);
		params.add(pair1);
		params.add(pair2);
		// params.add(new BasicNameValuePair("par",
		// "HttpClient_android_Post"));
		System.out.println(params.toString());
		JSONObject newJsonObject = HttpRequestUtils.httpPost(urlString, params);
		result = (String) newJsonObject.get("flag");
	}

}
