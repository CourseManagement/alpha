package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.courseInfo;
import com.DataLayer.Model.teacherAndSelectInfo;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.DomainLayer.Account.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @parameter *
 */
public class queryTeacherByCourse {
	private List<teacherAndSelectInfo> teachers;
	private String courseid;
	private String periodid;
	private static String URL = "http://test.micromi.net/service/CourseManagement/queryteacherBycourse.php";

	public List<teacherAndSelectInfo> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<teacherAndSelectInfo> teachers) {
		this.teachers = teachers;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	//
	public String docomfirm() {
		// init
		String result = "";
		Gson gson = new Gson();

		// pre
		teachers = new ArrayList<teacherAndSelectInfo>();
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("periodid", periodid);
		NameValuePair pair2 = new BasicNameValuePair("courseid", courseid);
		params.add(pair1);
		params.add(pair2);
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
		teachers = gson.fromJson(
				nthread.getJsonObject().getJSONArray("result_arr").toString(),
				new TypeToken<List<teacherAndSelectInfo>>() {
				}.getType());
		return result;
	}
}
