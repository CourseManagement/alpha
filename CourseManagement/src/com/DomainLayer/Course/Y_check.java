package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.DataLayer.CourseMangementModule.queryMajorState;
import com.DataLayer.Model.majorState;
import com.control.R;

public class Y_check extends Activity implements OnClickListener {

	Button btjs;
	Button btjz;
	Button btjsj;
	Button btrj;
	Button btsxsy;
	Button btsx;
	Button btwl;
	Button btxa;
	ImageButton back;
	ImageButton complish;
	List<majorState> majorstates = new ArrayList<majorState>();
	private String majorid;
	private String periodid;
	private String starttime;
	private String deadline;

	TextView dead;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.y_check);
		Intent intent = getIntent();
		periodid = intent.getStringExtra("periodid");

		btjs = (Button) this.findViewById(R.id.jsjsy);
		btjz = (Button) this.findViewById(R.id.jsjzy);
		btjsj = (Button) this.findViewById(R.id.jsj);
		btrj = (Button) this.findViewById(R.id.rjgc);
		btsxsy = (Button) this.findViewById(R.id.sxsy);
		btsx = (Button) this.findViewById(R.id.sx);
		btwl = (Button) this.findViewById(R.id.wlgc);
		btxa = (Button) this.findViewById(R.id.xxaq);
		back = (ImageButton) this.findViewById(R.id.back);
		complish = (ImageButton) this.findViewById(R.id.confirm);
		dead = (TextView) this.findViewById(R.id.dtime);

		// 返回上一级
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // 切换动画

			}
		});
		complish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		queryMajorState major = new queryMajorState();

		major.setPeriodid(periodid);
		major.docomfirm();
		starttime = major.getStarttime();
		deadline = major.getDeadline();
		dead.setText(starttime + "至" + deadline);

		btjs.setOnClickListener(this);
		btjz.setOnClickListener(this);
		btjsj.setOnClickListener(this);
		btrj.setOnClickListener(this);
		btsxsy.setOnClickListener(this);
		btsx.setOnClickListener(this);
		btwl.setOnClickListener(this);
		btxa.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.jsjsy:
			majorid = "0";
			break;
		case R.id.jsjzy:
			majorid = "1";
			break;
		case R.id.jsj:
			majorid = "2";
			break;
		case R.id.rjgc:
			majorid = "3";
			break;
		case R.id.sxsy:
			majorid = "4";
			break;
		case R.id.sx:
			majorid = "5";
			break;
		case R.id.wlgc:
			majorid = "6";
			break;
		case R.id.xxaq:
			majorid = "7";
			break;
		default:
			break;
		}

		Intent intent = new Intent(Y_check.this, Y_checkcourse.class);
		intent.putExtra("major", majorid);
		intent.putExtra("periodid", periodid);
		startActivity(intent);
		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left); // 切换动画

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

}
