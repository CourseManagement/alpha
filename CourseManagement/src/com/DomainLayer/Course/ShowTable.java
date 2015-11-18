package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import com.DataLayer.Model.courseInfo;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ShowTable extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coursemanage);
		
		Intent intent = getIntent();
		List<courseInfo> lvcourseInfo = new ArrayList<courseInfo>();
		ListView lv = (ListView) this.findViewById(R.id.lvcourse);
		List<String> str = new ArrayList<String>();
		
		
		
		
		
		
		
	}

}
