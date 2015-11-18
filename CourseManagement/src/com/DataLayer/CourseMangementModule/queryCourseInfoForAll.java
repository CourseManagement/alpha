package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.courseInfo;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @parameter *
 *
 *            查询所有课程信息
 *
 */
public class queryCourseInfoForAll {
	private static String URL = "http://test.micromi.net/service/CourseManagement/queryCourses.php";
	private String periodid;
	private List<courseInfo> courseInfos;

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public List<courseInfo> getCourseInfos() {
		return courseInfos;
	}

	public void setCourseInfos(List<courseInfo> courseInfos) {
		this.courseInfos = courseInfos;
	}

	public String docomfirm() {
		// init
		String result = "";
		Gson gson = new Gson();

		// pre
		courseInfos = new ArrayList<courseInfo>();
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
		result = nthread.getJsonObject().get("return_flag").toString();
		courseInfos = gson.fromJson(
				nthread.getJsonObject().getJSONArray("result_arr").toString(),
				new TypeToken<List<courseInfo>>() {
				}.getType());
		return result;
	}

}
