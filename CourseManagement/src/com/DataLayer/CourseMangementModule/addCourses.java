package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.courseInfo;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;

/**
 * @parameter *
 *
 *            批量添加课程
 *
 */
public class addCourses {

	private String URL = "http://test.micromi.net/service/CourseManagement/addCourses.php";
	private String major;
	private String periodid;
	private List<courseInfo> courseInfos;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

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

	public String doComfirm() {
		// pre
		String result = null;
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		// data
		NameValuePair pair1 = new BasicNameValuePair("major", major);
		NameValuePair pair2 = new BasicNameValuePair("periodid", periodid);
		Gson gson = new Gson();
		NameValuePair pair3 = new BasicNameValuePair("info",
				gson.toJson(courseInfos));
		params.add(pair1);
		params.add(pair2);
		params.add(pair3);
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
		// System.out.println(nthread.getJsonObject().toString());
		return nthread.getJsonObject().get("flag").toString();
	}
}
