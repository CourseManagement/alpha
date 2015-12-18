package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.DataLayer.CourseMangementModule.queryCourseInfoForMajor;
import com.DataLayer.Model.courseInfo;
import com.DomainLayer.XAccount.CheckSelectInfo;
import com.DomainLayer.XAccount.showCourseInfoAndSelectedTeacher;
import com.control.R;

public class Y_checkcourse extends Activity implements OnItemClickListener {
	
	
	

	private List<courseInfo> courseInfos;// courseInfo

	private String periodid;
	private String major;
	private ListView ListView;
	private ImageButton back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.x_check);

		// pre data
		Intent intent = this.getIntent();
		periodid = intent.getStringExtra("periodid");
		major = intent.getStringExtra("major");// tem
		ListView = (android.widget.ListView) this.findViewById(R.id.courselist);

		// query courseinfo for major
		queryCourseInfoForMajor queryCourseInfoForMajor = new queryCourseInfoForMajor();
		queryCourseInfoForMajor.setMajor(major);
		queryCourseInfoForMajor.setPeriodid(periodid);
		queryCourseInfoForMajor.docomfirm();
		courseInfos = queryCourseInfoForMajor.getCourseInfos();

		// set data
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				R.layout.check_select_info_item, new String[] { "coursename",
						"nums" }, new int[] { R.id.coursename, R.id.nums });
		ListView.setAdapter(adapter);
		ListView.setOnItemClickListener(this);
		back = (ImageButton) this.findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // ÇÐ»»¶¯»­

			}
		});

	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (courseInfo courseInfo : courseInfos) {
			Map<String, Object> temMap = new HashMap<String, Object>();
			temMap.put("coursename", courseInfo.getCoursename());
			System.out.println(courseInfo.getNums());
			temMap.put("nums", courseInfo.getNums());
			list.add(temMap);
		}

		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("title", "G1");
		// map.put("info", "google 1");
		// map.put("img", R.drawable.i1);
		// list.add(map);

		return list;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		courseInfo selectedCourseInfo = courseInfos.get(position);
		Intent intent = new Intent(Y_checkcourse.this,
				Showcourse.class);
		intent.putExtra("Coursegrade", selectedCourseInfo.getCoursegrade());
		intent.putExtra("Coursehour", selectedCourseInfo.getCoursehour());
		intent.putExtra("Courseid", selectedCourseInfo.getCourseid());
		intent.putExtra("Coursemajor", selectedCourseInfo.getCoursemajor());
		intent.putExtra("Coursename", selectedCourseInfo.getCoursename());
		intent.putExtra("Coursepeople", selectedCourseInfo.getCoursepeople());
		intent.putExtra("Coursescore", selectedCourseInfo.getCoursescore());
		intent.putExtra("Practicehour", selectedCourseInfo.getPracticehour());
		intent.putExtra("Nums", selectedCourseInfo.getNums());
		intent.putExtra("Testhour", selectedCourseInfo.getTesthour());
		intent.putExtra("Type", selectedCourseInfo.getType());
		intent.putExtra("periodid", periodid);
		startActivity(intent);
		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left); // ÇÐ»»¶¯»­
	}

}
