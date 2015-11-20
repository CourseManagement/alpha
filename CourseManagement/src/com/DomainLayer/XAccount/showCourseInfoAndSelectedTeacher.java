package com.DomainLayer.XAccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.control.R;

/**
 * @parameter *
 */
public class showCourseInfoAndSelectedTeacher extends Activity {

	private Intent intent;

	private TextView grade;
	private TextView num;
	private TextView mark;
	private TextView type;
	private TextView stime;
	private TextView sjtime;
	private TextView ptime;
	private String Coursegrade;
	private String Coursehour;
	private String Courseid;
	private String Coursemajor;
	private String Coursename;
	private String Coursepeople;
	private String Coursescore;
	private String Practicehour;
	private String Testhour;
	private String Nums;
	private String Type;

	private ImageButton add;
	private ImageButton back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.course_check_detail);

		intent = this.getIntent();
		init();

	}

	void init() {
		add = (ImageButton) this.findViewById(R.id.addcourse);
		back = (ImageButton) this.findViewById(R.id.back);

		grade = (TextView) this.findViewById(R.id.grade);
		num = (TextView) this.findViewById(R.id.num);
		mark = (TextView) this.findViewById(R.id.mark);
		type = (TextView) this.findViewById(R.id.type);
		stime = (TextView) this.findViewById(R.id.stime);
		sjtime = (TextView) this.findViewById(R.id.sjtime);
		ptime = (TextView) this.findViewById(R.id.ptime);

		Coursegrade = intent.getStringExtra("Coursegrade");
		Coursehour = intent.getStringExtra("Coursehour");
		Courseid = intent.getStringExtra("Courseid");
		Coursemajor = intent.getStringExtra("Coursemajor");
		Coursename = intent.getStringExtra("Coursename");
		Coursepeople = intent.getStringExtra("Coursepeople");
		Coursescore = intent.getStringExtra("Coursescore");
		Practicehour = intent.getStringExtra("Practicehour");
		Nums = intent.getStringExtra("Nums");
		Testhour = intent.getStringExtra("Testhour");
		Type = intent.getStringExtra("Type");

		grade.setText(Coursegrade);
		num.setText(Coursepeople);
		mark.setText(Coursescore);
		type.setText(Type);
		stime.setText(Coursehour);
		sjtime.setText(Practicehour);
		ptime.setText(Testhour);
	}

}
