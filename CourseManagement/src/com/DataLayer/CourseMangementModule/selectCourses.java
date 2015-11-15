package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.selectCoursesInfo;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;

/**
 * @parameter *
 *
 *            Ñ¡¿Î½Ó¿Ú
 *
 */
public class selectCourses {

	private static String URL = "http://test.micromi.net/service/CourseManagement/selectCourses.php";
	private String periodid;
	private String user_name;
	private List<selectCoursesInfo> selectCoursesInfos;

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<selectCoursesInfo> getSelectCoursesInfos() {
		return selectCoursesInfos;
	}

	public void setSelectCoursesInfos(List<selectCoursesInfo> selectCoursesInfos) {
		this.selectCoursesInfos = selectCoursesInfos;
	}

	public String doComfirm() {
		// pre
		String result = null;
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();

		// data
		NameValuePair pair1 = new BasicNameValuePair("periodid", periodid);
		NameValuePair pair2 = new BasicNameValuePair("user_name", user_name);
		Gson gson = new Gson();
		NameValuePair pair3 = new BasicNameValuePair("info",
				gson.toJson(selectCoursesInfos));
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
		return nthread.getJsonObject().get("return_flag").toString();
	}

}
