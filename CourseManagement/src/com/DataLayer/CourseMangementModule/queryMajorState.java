package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.majorState;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @parameter
 *
 *            查询课表导入情况
 *
 */
public class queryMajorState {

	private static String URL = "http://test.micromi.net/service/CourseManagement/queryChecks.php";
	private String periodid;
	private List<majorState> majorStates;
	private String starttime;
	private String deadline;

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public List<majorState> getMajorStates() {
		return majorStates;
	}

	public void setMajorStates(List<majorState> majorStates) {
		this.majorStates = majorStates;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String docomfirm() {
		// init
		String result = "";
		Gson gson = new Gson();

		// pre
		majorStates = new ArrayList<majorState>();
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
		starttime = nthread.getJsonObject().get("starttime").toString();;
		deadline = nthread.getJsonObject().get("deadline").toString();
		result = nthread.getJsonObject().get("return_flag").toString();
		majorStates = gson.fromJson(
				nthread.getJsonObject().getJSONArray("result_arr").toString(),
				new TypeToken<List<majorState>>() {
				}.getType());
		return result;
	}

}
