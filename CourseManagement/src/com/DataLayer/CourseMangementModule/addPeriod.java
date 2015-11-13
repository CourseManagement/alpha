package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Runnable.threadAdapterForPost;

/**
 * @parameter *
 *
 *            添加学期接口
 *
 */
public class addPeriod {

	private String periodid;
	private static String URL = "http://test.micromi.net/service/PeriorManagement/addPerior.php";

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public String docomfirm() {
		// init
		String result = "";

		// pre
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("periodid", periodid);
		params.add(pair1);
		nthread.setUrlString(URL);
		nthread.setParams(params);

		// doit
		nthread.start();
		try {
			nthread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// result
		result = nthread.getJsonObject().get("flag").toString();
		return result;
	}

}
