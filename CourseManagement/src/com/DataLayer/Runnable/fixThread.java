package com.DataLayer.Runnable;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DUtils.HttpRequestUtils;

public class fixThread extends Thread {
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





	public JSONObject getJsonObject() {
		return jsonObject;
	}


	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}


	public String getReturn_flag() {
		return return_flag;
	}


	public void setReturn_flag(String return_flag) {
		this.return_flag = return_flag;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		return_flag = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 添加要传递的参数
        
		NameValuePair pair1 = new BasicNameValuePair("flag", flag);
		NameValuePair pair2 = new BasicNameValuePair("info", jsonObject.toString());
		params.add(pair1);
		params.add(pair2);
		// "HttpClient_android_Post"));
		System.out.println(params.toString());
		JSONObject newJsonObject = HttpRequestUtils.httpPost(urlString, params);
		return_flag = (String) newJsonObject.get("return_flag");
	}

}
