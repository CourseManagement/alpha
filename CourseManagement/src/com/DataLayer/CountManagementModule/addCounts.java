package com.DataLayer.CountManagementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.departmentmanager;
import com.DataLayer.Model.teacher;
import com.DataLayer.Runnable.threadAdapterForPost;
import com.google.gson.Gson;

/**
 * @parameter *
 */
public class addCounts {

	private String flag;
	private List<teacher> teachers;
	private departmentmanager departmentmanager;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<teacher> teachers) {
		this.teachers = teachers;
	}

	public departmentmanager getDepartmentmanager() {
		return departmentmanager;
	}

	public void setDepartmentmanager(departmentmanager departmentmanager) {
		this.departmentmanager = departmentmanager;
	}

	public String doComfirm() {
		String result = null;
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		NameValuePair pair1 = new BasicNameValuePair("flag", flag);
		Gson gson = new Gson();
		NameValuePair pair2;
		if (flag.equals("1")) {
			// 添加要传递的参数
			pair2 = new BasicNameValuePair("info",
					gson.toJson(departmentmanager));
		} else {
			pair2 = new BasicNameValuePair("info", gson.toJson(teachers));
		}
		params.add(pair1);
		params.add(pair2);
		nthread.setUrlString("http://test.micromi.net/service/addCount.php");
		nthread.setParams(params);
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
