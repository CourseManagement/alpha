package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.Period;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @parameter *
 *
 *            学期查询接口，直接调用无需设置参数
 *
 */
public class queryPeriod {

	private static String flag = "1";
	private List<Period> periods;

	public List<Period> getPeriors() {
		return periods;
	}

	public void setPeriors(List<Period> periods) {
		this.periods = periods;
	}

	public String docomfirm() {
		// init
		String result = "";
		Gson gson = new Gson();

		// pre
		periods = new ArrayList<Period>();
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("flag", flag);
		params.add(pair1);
		nthread.setUrlString("http://test.micromi.net/service/PeriorManagement/queryPerior.php");
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
		result = nthread.getJsonObject().get("return_flag").toString();
		periods = gson.fromJson(
				nthread.getJsonObject().getJSONArray("result_arr").toString(),
				new TypeToken<List<Period>>() {
				}.getType());
		return result;
	}

}
