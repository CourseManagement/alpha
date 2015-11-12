package com.DataLayer.Runnable;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import com.DUtils.HttpRequestUtils;

/**
 * @parameter *
 */
public class threadAdapterForPost extends Thread {
	private String urlString;
	private List<NameValuePair> params;
	private JSONObject jsonObject;

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	public List<NameValuePair> getParams() {
		return params;
	}

	public void setParams(List<NameValuePair> params) {
		this.params = params;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		jsonObject = HttpRequestUtils.httpPost(urlString, params);
	}
}
