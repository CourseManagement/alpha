package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import com.DUtils.FileUtils;
import com.DataLayer.CourseMangementModule.addCourses;
import com.DataLayer.CourseMangementModule.doUpload;
import com.DataLayer.CourseMangementModule.getInfoFromExcelAboutCourses;
import com.DataLayer.CourseMangementModule.queryMajorState;
import com.DataLayer.Model.majorState;
import com.control.R;

import android.app.Activity;
import android.bluetooth.BluetoothClass.Device.Major;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AddcsTable extends Activity implements OnClickListener {

	Button btjs;
	Button btjz;
	Button btjsj;
	Button btrj;
	Button btsxsy;
	Button btsx;
	Button btwl;
	Button btxa;
	private String majorid;
	private String periodid;
	private String path;

	private static final int FILE_SELECT_CODE = 1;

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
		periodid = intent.getStringExtra("per");
		major.setPeriodid(periodid);
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
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		try {
			startActivityForResult(
					Intent.createChooser(intent, "Select a File to Upload"),
					FILE_SELECT_CODE);
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(getApplicationContext(),
					"Please install a File Manager.", Toast.LENGTH_SHORT)
					.show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case FILE_SELECT_CODE:
			if (resultCode == RESULT_OK) {
				// Get the Uri of the selected file
				Uri uri = data.getData();
				String path = FileUtils.getPath(this, uri);
				// 上传课表
				String a = path;
				String b = a.substring(a.lastIndexOf("/") + 1, a.length());
				doUpload doUpload = new doUpload();
				doUpload.setFilename(b);
				doUpload.setUploadfile(a);
				doUpload.setMajor(majorid);
				doUpload.setPeroidid(periodid);
				doUpload.docomfirm();
				Toast.makeText(getApplicationContext(), "上传成功",
						Toast.LENGTH_SHORT).show();
				// 向数据库中插入课表
				getInfoFromExcelAboutCourses getInfo = new getInfoFromExcelAboutCourses();
				getInfo.setPath(path);
				getInfo.setPeriodid(periodid);
				getInfo.setMajor(majorid);
				getInfo.start();
				try {
					getInfo.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String result = getInfo.getResult();
				if(result.equals("")){}//TODO
				break;
			}
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

}
