package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import com.DataLayer.CourseMangementModule.queryMajorState;
import com.DataLayer.Model.majorState;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AddcsTable extends Activity {

	Button btjs;
	Button btjz;
	Button btjsj;
	Button btrj;
	Button btsxsy;
	Button btsx;
	Button btwl;
	Button btxa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addcstable);

		btjs = (Button) findViewById(R.id.jsjsy);
		btjz = (Button) findViewById(R.id.jsjzy);
		btjsj = (Button) findViewById(R.id.jsj);
		btrj = (Button) findViewById(R.id.rjgc);
		btsxsy = (Button) findViewById(R.id.sxsy);
		btsx = (Button) findViewById(R.id.sx);
		btwl = (Button) findViewById(R.id.wlgc);
		btxa = (Button) findViewById(R.id.xxaq);

		Intent intent = getIntent();
		queryMajorState major = new queryMajorState();
		major.setPeriodid(intent.getStringExtra("per"));
		major.docomfirm();
		List<majorState> majorstates = new ArrayList<majorState>();
		majorstates = major.getMajorStates();
		for (majorState mState : majorstates) {
			if (mState.getMajor().equals("计算机(实验班)")
					&& mState.getSituation().equals("1")) {
				btjs.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("计算机(卓越班)")
					&& mState.getSituation().equals("1")) {
				btjz.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("计算机专业")
					&& mState.getSituation().equals("1")) {
				btjsj.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("软件工程专业")
					&& mState.getSituation().equals("1")) {
				btrj.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("数学类(实验班)")
					&& mState.getSituation().equals("1")) {
				btsxsy.setBackgroundColor(getResources()
						.getColor(R.color.green));
			}
			if (mState.getMajor().equals("数学类")
					&& mState.getSituation().equals("1")) {
				btsx.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("网络工程专业")
					&& mState.getSituation().equals("1")) {
				btwl.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("信息安全专业")
					&& mState.getSituation().equals("1")) {
				btxa.setBackgroundColor(getResources().getColor(R.color.green));
			}

		}

		btjs.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();

			}
		});
		btjz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});
		btjsj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});
		btrj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});
		btsxsy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});
		btsx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});
		btwl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});
		btxa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "11", 200).show();
				
			}
		});

	}

}
