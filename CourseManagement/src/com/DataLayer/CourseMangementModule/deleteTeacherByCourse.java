package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Runnable.threadAdapterForPost;

/**
 * @parameter *
 */
public class deleteTeacherByCourse {
	// periodid=201502&courseid=1&user_name=12345
	private String periodid;
	private String courseid;
	private String user_name;

	private static String URL = "http://test.micromi.net/service/CourseManagement/deleteTeacherByCourse.php";

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String docomfirm() {
		// init
		String result = "";

		// pre
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("periodid", periodid);
		NameValuePair pair2 = new BasicNameValuePair("courseid", courseid);
		NameValuePair pair3 = new BasicNameValuePair("user_name", user_name);
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

		// result
		result = nthread.getJsonObject().get("flag").toString();
		return result;
	}
}
