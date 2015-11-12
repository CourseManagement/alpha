package com.DataLayer;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Runnable.threadAdapterForPost;

/**
 * @parameter *
 */
public class deleteCount {
	private String flag;
	private String user_name;

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

	public String doComfirm() {
		String result = null;
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("flag", flag);
		NameValuePair pair2 = new BasicNameValuePair("user_name", user_name);
		params.add(pair1);
		params.add(pair2);
		nthread.setUrlString("http://test.micromi.net/service/userInfoDelete.php");
		nthread.setParams(params);
		nthread.start();
		try {
			nthread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(nthread.getJsonObject().toString());
		result = nthread.getJsonObject().get("return_flag").toString();
		return result;
	}
}
