package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.DUtils.FileUtils;
import com.DataLayer.CourseMangementModule.beginSelectCourse;
import com.DataLayer.CourseMangementModule.doUpload;
import com.DataLayer.CourseMangementModule.getInfoFromExcelAboutCourses;
import com.DataLayer.CourseMangementModule.queryMajorState;
import com.DataLayer.Model.majorState;
import com.control.R;

public class AddcsTable extends Activity implements OnClickListener {

	Button btjs;
	Button btjz;
	Button btjsj;
	Button btrj;
	Button btsxsy;
	Button btsx;
	Button btwl;
	Button btxa;
	ImageButton back;
	Button settime;
	ImageButton complish;
	List<majorState> majorstates = new ArrayList<majorState>();
	private String majorid;
	private String periodid;
	private String path;
	private int btid;
	DatePicker begin;
	DatePicker close;
	TextView bgtest;
	TextView cltest;
	int[] marflag = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int timeflag = 0;
	

	private static final int FILE_SELECT_CODE = 1;
	private String starttime;
	private String deadline;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.addcstable);
		Intent intent = getIntent();
		periodid = intent.getStringExtra("per");

		btjs = (Button) this.findViewById(R.id.jsjsy);
		btjz = (Button) this.findViewById(R.id.jsjzy);
		btjsj = (Button) this.findViewById(R.id.jsj);
		btrj = (Button) this.findViewById(R.id.rjgc);
		btsxsy = (Button) this.findViewById(R.id.sxsy);
		btsx = (Button) this.findViewById(R.id.sx);
		btwl = (Button) this.findViewById(R.id.wlgc);
		btxa = (Button) this.findViewById(R.id.xxaq);
		back = (ImageButton) this.findViewById(R.id.title_cancel);
		complish = (ImageButton) this.findViewById(R.id.title_acomplish);
		settime = (Button) this.findViewById(R.id.settime);
		bgtest = (TextView) this.findViewById(R.id.begintext);
		cltest = (TextView) this.findViewById(R.id.closetext);
		// 返回上一级
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AddcsTable.this,Ccoursemage.class);
				startActivity(intent);
				finish();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // 切换动画

			}
		});
		complish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int n = 0;
				for (int i = 0; i < 8; i++) {
					if (marflag[1]==0) {
						n=1;
					}
				}
				if (n==0 && timeflag==1) {
					beginSelectCourse beginSelectCourse = new beginSelectCourse();
					beginSelectCourse.setPeriodid(periodid);
					beginSelectCourse.setFlag("2");
					beginSelectCourse.setStarttime(starttime);
					beginSelectCourse.setDeadline(deadline);
					if (beginSelectCourse.docomfirm().equals("y1")) {
						Intent intent = new Intent(AddcsTable.this,Ccoursemage.class);
						startActivity(intent);
						finish();
						overridePendingTransition(android.R.anim.slide_in_left,
								android.R.anim.slide_out_right); // 切换动画
						
					} else {
						Toast.makeText(getApplicationContext(), "提交失败，请重试！", 200).show();
					}
					
				} else {
					Toast.makeText(getApplicationContext(), "课表未完全导入或未设置时间", 200).show();
				}
				
				
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
				builder.setTitle("设置时间");
				builder.setView(textEntryView);
				builder.setPositiveButton("确定",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								// 事件处理
								begin = (DatePicker) textEntryView
										.findViewById(R.id.begin);
								close = (DatePicker) textEntryView
										.findViewById(R.id.close);

								int y1, y2, m1, m2, d1, d2;
								y1 = begin.getYear();
								y2 = close.getYear();
								m1 = begin.getMonth() + 1;
								m2 = close.getMonth() + 1;
								d1 = begin.getDayOfMonth();
								d2 = close.getDayOfMonth();
								beginSelectCourse beginSelectCourse = new beginSelectCourse();
								starttime = String.valueOf(y1) + "-"
										+ String.valueOf(m1) + "-"
										+ String.valueOf(d1);
								deadline = String.valueOf(y2) + "-"
										+ String.valueOf(m2) + "-"
										+ String.valueOf(d2);
								beginSelectCourse.setDeadline(deadline);
								beginSelectCourse.setStarttime(starttime);
								beginSelectCourse.setFlag("1");
								beginSelectCourse.setPeriodid(periodid);

								if (y2 > y1) {
									bgtest.setText("开始时间：" + y1 + "-" + m1
											+ "-" + d1);
									cltest.setText("结束时间：" + y2 + "-" + m2
											+ "-" + d2);
									beginSelectCourse.docomfirm();
									timeflag = 1;

								} else if (m2 > m1) {
									bgtest.setText("开始时间：" + y1 + "-" + m1
											+ "-" + d1);
									cltest.setText("结束时间：" + y2 + "-" + m2
											+ "-" + d2);
									beginSelectCourse.docomfirm();
									timeflag = 1;

								} else if (d2 > d1) {
									bgtest.setText("开始时间：" + y1 + "-" + m1
											+ "-" + d1);
									cltest.setText("结束时间：" + y2 + "-" + m2
											+ "-" + d2);
									beginSelectCourse.docomfirm();
									timeflag = 1;

								} else {
									Toast.makeText(getApplicationContext(),
											"开始时间不能大于结束时间，请重新输入！", 200).show();
								}

							}

						});
				builder.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						});
				builder.create().show();

			}
		});

		queryMajorState major = new queryMajorState();

		major.setPeriodid(periodid);
		major.docomfirm();
		starttime = major.getStarttime();
		deadline = major.getDeadline();
		bgtest.setText("开始时间：" + starttime);
		cltest.setText("结束时间：" + deadline);
		if (starttime.equals("0000-00-00")) {
			
		}else {
			timeflag = 1;
		}

		majorstates = major.getMajorStates();
		for (majorState mState : majorstates) {
			if (mState.getMajor().equals("计算机(实验班)")
					&& mState.getSituation().equals("1")) {
				marflag[0] = 1;
				btjs.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("计算机(卓越班)")
					&& mState.getSituation().equals("1")) {
				marflag[1] = 1;
				btjz.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("计算机专业")
					&& mState.getSituation().equals("1")) {
				marflag[2] = 1;
				btjsj.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("软件工程专业")
					&& mState.getSituation().equals("1")) {
				marflag[3] = 1;
				btrj.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("数学类(实验班)")
					&& mState.getSituation().equals("1")) {
				marflag[4] = 1;
				btsxsy.setBackgroundColor(getResources()
						.getColor(R.color.green));
			}
			if (mState.getMajor().equals("数学类")
					&& mState.getSituation().equals("1")) {
				marflag[5] = 1;
				btsx.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("网络工程专业")
					&& mState.getSituation().equals("1")) {
				marflag[6] = 1;
				btwl.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if (mState.getMajor().equals("信息安全专业")
					&& mState.getSituation().equals("1")) {
				marflag[7] = 1;
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

		if (marflag[Integer.parseInt(majorid)] == 1) {
			Intent intent = new Intent(AddcsTable.this, ShowTable.class);
			intent.putExtra("major", majorid);
			intent.putExtra("per", periodid);
			startActivity(intent);
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left); // 切换动画
		} else {
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
				if (result.equals("y1")) {
					Toast.makeText(getApplicationContext(), "插入成功！", 200)
							.show();
					Button temBt = (Button) this.findViewById(btid);
					marflag[Integer.parseInt(majorid)] = 1;
					temBt.setBackgroundColor(getResources().getColor(
							R.color.green));
				} else {
					Toast.makeText(getApplicationContext(), "插入失败！", 200)
							.show();
				}
				break;
			}
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

}
