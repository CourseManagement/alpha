package com.DataLayer.CourseMangementModule;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.DataLayer.Model.majorFlags;
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
public class queryMajorFlags {

	private static String URL = "http://test.micromi.net/service/CourseManagement/queryFlags.php";
	private List<majorFlags> majorFlags;

	public List<majorFlags> getMajorFlags() {
		return majorFlags;
	}

	public void setMajorFlags(List<majorFlags> majorFlags) {
		this.majorFlags = majorFlags;
	}

	public String docomfirm() {
		// init
		String result = "";
		Gson gson = new Gson();

		// pre
		majorFlags = new ArrayList<majorFlags>();
		threadAdapterForPost nthread = new threadAdapterForPost();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		nthread.setUrlString(URL);

		// doit
		nthread.start();
		try {
			nthread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = nthread.getJsonObject().get("return_flag").toString();
		majorFlags = gson.fromJson(
				nthread.getJsonObject().getJSONArray("result_arr").toString(),
				new TypeToken<List<majorFlags>>() {
				}.getType());
		return result;
	}

}
