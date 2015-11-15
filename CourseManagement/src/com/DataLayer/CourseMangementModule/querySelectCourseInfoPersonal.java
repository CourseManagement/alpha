package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.selectCoursesDetailInfo;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @parameter *
 *
 *            查询个人选课信息
 *
 */
public class querySelectCourseInfoPersonal {

	private static String URL = "http://test.micromi.net/service/CourseManagement/querySelectCourseByPersonal.php";
	private String user_name;
	private String periodid;
	private List<selectCoursesDetailInfo> selectCoursesDetailInfos;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPeriodid() {
		return periodid;
	}

	public void setPeriodid(String periodid) {
		this.periodid = periodid;
	}

	public List<selectCoursesDetailInfo> getSelectCoursesDetailInfos() {
		return selectCoursesDetailInfos;
	}

	public void setSelectCoursesDetailInfos(
			List<selectCoursesDetailInfo> selectCoursesDetailInfos) {
		this.selectCoursesDetailInfos = selectCoursesDetailInfos;
	}

	public String docomfirm() {
		// init
		String result = "";
		Gson gson = new Gson();

		// pre
		selectCoursesDetailInfos = new ArrayList<selectCoursesDetailInfo>();
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("periodid", periodid);
		NameValuePair pair2 = new BasicNameValuePair("user_name", user_name);
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
		selectCoursesDetailInfos = gson.fromJson(
				nthread.getJsonObject().getJSONArray("result_arr").toString(),
				new TypeToken<List<selectCoursesDetailInfo>>() {
				}.getType());
		return result;
	}

}
