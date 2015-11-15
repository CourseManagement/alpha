package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import com.DUtils.FileUtils;
import com.DataLayer.CourseMangementModule.addPeriod;
import com.DataLayer.CourseMangementModule.doUpload;
import com.DataLayer.CourseMangementModule.getInfoFromExcelAboutCourses;
import com.DataLayer.CourseMangementModule.queryMajorState;
import com.DataLayer.Model.majorState;
import com.DomainLayer.Course.Ccoursemage.MessageItem;
import com.DomainLayer.Course.Ccoursemage.SlideAdapter;
import com.UIxml.ListViewCompat1;
import com.control.R;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
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
	Button back;
	Button settime;
	private String majorid;
	private String periodid;
	private String path;
	private int btid;
	DatePicker begin;
	DatePicker close;
	TextView bgtest;
	TextView cltest;

	private static final int FILE_SELECT_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.addcstable);

		btjs = (Button) findViewById(R.id.jsjsy);
		btjz = (Button) findViewById(R.id.jsjzy);
		btjsj = (Button) findViewById(R.id.jsj);
		btrj = (Button) findViewById(R.id.rjgc);
		btsxsy = (Button) findViewById(R.id.sxsy);
		btsx = (Button) findViewById(R.id.sx);
		btwl = (Button) findViewById(R.id.wlgc);
		btxa = (Button) findViewById(R.id.xxaq);
		back = (Button) findViewById(R.id.title_cancel);
		settime = (Button) findViewById(R.id.settime);
		// ������һ��
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // �л�����

			}
		});
		settime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						AddcsTable.this);
				LayoutInflater factory = LayoutInflater.from(AddcsTable.this);
				final View textEntryView = factory.inflate(
						R.layout.date_dialog, null);
				builder.setTitle("����ʱ��");
				builder.setView(textEntryView);
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// �¼�����
								begin = (DatePicker) textEntryView
										.findViewById(R.id.begin);
								close = (DatePicker) textEntryView
										.findViewById(R.id.close);
								bgtest = (TextView) findViewById(R.id.begintext);
								cltest = (TextView) findViewById(R.id.closetext);
								int y1, y2, m1, m2, d1, d2;
								y1 = begin.getYear();
								y2 = close.getYear();
								m1 = begin.getMonth();
								m2 = close.getMonth();
								d1 = begin.getDayOfMonth();
								d2 = close.getDayOfMonth();
								if (y2 > y1) {
									bgtest.setText("��ʼʱ�䣺" + y1 + "-" + m1
											+ "-" + d1);
									cltest.setText("����ʱ�䣺" + y2 + "-" + m2
											+ "-" + d2);

								} else if (m2 > m1) {
									bgtest.setText("��ʼʱ�䣺" + y1 + "-" + m1
											+ "-" + d1);
									cltest.setText("����ʱ�䣺" + y2 + "-" + m2
											+ "-" + d2);

								} else if (d2 > d1) {
									bgtest.setText("��ʼʱ�䣺" + y1 + "-" + m1
											+ "-" + d1);
									cltest.setText("����ʱ�䣺" + y2 + "-" + m2
											+ "-" + d2);

								} else {
									Toast.makeText(getApplicationContext(),
											"��ʼʱ�䲻�ܴ��ڽ���ʱ�䣬���������룡", 200).show();
								}

							}

						});
				builder.setNegativeButton("ȡ��",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						});
				builder.create().show();

			}
		});

		Intent intent = getIntent();
		queryMajorState major = new queryMajorState();
		periodid = intent.getStringExtra("per");
		major.setPeriodid(periodid);
		major.docomfirm();
		List<majorState> majorstates = new ArrayList<majorState>();
		majorstates = major.getMajorStates();
		for (majorState mState : majorstates) {
			if (mState.getMajor().equals("�����(ʵ���)")
					&& mState.getSituation().equals("1")) {
				btjs.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("�����(׿Խ��)")
					&& mState.getSituation().equals("1")) {
				btjz.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("�����רҵ")
					&& mState.getSituation().equals("1")) {
				btjsj.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("�������רҵ")
					&& mState.getSituation().equals("1")) {
				btrj.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("��ѧ��(ʵ���)")
					&& mState.getSituation().equals("1")) {
				btsxsy.setBackgroundColor(getResources()
						.getColor(R.color.green));
			}
			if (mState.getMajor().equals("��ѧ��")
					&& mState.getSituation().equals("1")) {
				btsx.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("���繤��רҵ")
					&& mState.getSituation().equals("1")) {
				btwl.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("��Ϣ��ȫרҵ")
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
		btid = v.getId();
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
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case FILE_SELECT_CODE:
			if (resultCode == RESULT_OK) {
				// Get the Uri of the selected file
				Uri uri = data.getData();
				path = FileUtils.getPath(this, uri);
				// �ϴ��α�
				String a = path;
				String b = a.substring(a.lastIndexOf("/") + 1, a.length());
				doUpload doUpload = new doUpload();
				doUpload.setFilename(b);
				doUpload.setUploadfile(a);
				doUpload.setMajor(majorid);
				doUpload.setPeroidid(periodid);
				doUpload.docomfirm();
				Toast.makeText(getApplicationContext(), "�ϴ��ɹ�",
						Toast.LENGTH_SHORT).show();
				// �����ݿ��в���α�
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
				if (result.equals("y1")) {
					Toast.makeText(getApplicationContext(), "����ɹ���", 200)
							.show();
					Button temBt = (Button) findViewById(btid);
					temBt.setBackgroundColor(getResources().getColor(
							R.color.green));
				} else {
					Toast.makeText(getApplicationContext(), "����ʧ�ܣ�", 200)
							.show();
				}
				break;
			}
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

}
