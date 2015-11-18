package com.DomainLayer.Course;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.DUtils.FileUtils;
import com.DataLayer.CourseMangementModule.addPeriod;
import com.DataLayer.CourseMangementModule.doUpload;
import com.DataLayer.CourseMangementModule.getInfoFromExcelAboutCourses;
import com.DataLayer.CourseMangementModule.queryCourseInfoForMajor;
import com.DataLayer.Model.courseInfo;
import com.DomainLayer.Course.Ccoursemage.MessageItem;
import com.DomainLayer.Course.Ccoursemage.SlideAdapter;
import com.UIxml.ListViewCompat1;
import com.control.R;

public class ShowTable extends Activity {

	Button back;
	Button reset;
	private String path;
	private String majorid;
	private String periodid;
	private static final int FILE_SELECT_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.coursemesge);

		Intent intent = getIntent();
		majorid = intent.getStringExtra("major");
		periodid = intent.getStringExtra("per");
		String major = majorid;
		String per = periodid;
		ListView lv = (ListView) this.findViewById(R.id.lvcourse);
		List<String> Courselv = new ArrayList<String>();
		queryCourseInfoForMajor queyrCou = new queryCourseInfoForMajor();
		queyrCou.setMajor(major);
		queyrCou.setPeriodid(per);
		queyrCou.docomfirm();
		final List<courseInfo> lvcourseInfo = queyrCou.getCourseInfos();
		for (courseInfo courseInfo1 : lvcourseInfo) {
			String str = courseInfo1.getCoursename();
			Courselv.add(str);
		}
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, Courselv));

		back = (Button) this.findViewById(R.id.title_back);
		reset = (Button) this.findViewById(R.id.title_reset);

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // �л�����

			}
		});

		reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("*/*");
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				try {
					startActivityForResult(Intent.createChooser(intent,
							"Select a File to Upload"), FILE_SELECT_CODE);
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(getApplicationContext(),
							"Please install a File Manager.",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		lv.setOnItemClickListener(new OnItemClickListener(){
			 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                    long arg3) {
                // TODO Auto-generated method stub
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(
						ShowTable.this);
				LayoutInflater factory = LayoutInflater.from(ShowTable.this);
				final View textEntryView = factory.inflate(R.layout.coursemsg_dialog,
						null);
				builder.setView(textEntryView);
				courseInfo Info = lvcourseInfo.get(position);
				TextView nianji =  (TextView) textEntryView.findViewById(R.id.nianji);
				TextView zhuanye =  (TextView) textEntryView.findViewById(R.id.zhuanye);
				TextView renshu =  (TextView) textEntryView.findViewById(R.id.renshu);
				TextView mingchen =  (TextView) textEntryView.findViewById(R.id.mingchen);
				TextView leixing =  (TextView) textEntryView.findViewById(R.id.leixing);
				TextView xuefen =  (TextView) textEntryView.findViewById(R.id.xuefen);
				TextView xueshi =  (TextView) textEntryView.findViewById(R.id.xueshi);
				TextView shiyan =  (TextView) textEntryView.findViewById(R.id.shiyan);
				TextView shangji =  (TextView) textEntryView.findViewById(R.id.shangji);
				
				nianji.setText("�꼶��"+Info.getCoursegrade());
				zhuanye.setText("רҵ��"+Info.getCoursemajor());
				renshu.setText("רҵ������"+Info.getCoursepeople());
				mingchen.setText("�γ����ƣ�"+Info.getCoursename());
				leixing.setText("ѡ�����ͣ�"+Info.getType());
				xuefen.setText("ѧ�֣�"+Info.getCoursescore());
				xueshi.setText("ѧʱ��"+Info.getCoursehour());
				shiyan.setText("ʵ��ѧʱ��"+Info.getPracticehour());
				shangji.setText("�ϻ�ѧʱ��"+Info.getTesthour());
				builder.setTitle("�γ�����");
				builder.create().show();

			}
             
        });

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
					String major = majorid;
					String per = periodid;
					List<courseInfo> lvcourseInfo = new ArrayList<courseInfo>();
					ListView lv = (ListView) this.findViewById(R.id.lvcourse);
					List<String> Courselv = new ArrayList<String>();
					queryCourseInfoForMajor queyrCou = new queryCourseInfoForMajor();
					queyrCou.setMajor(major);
					queyrCou.setPeriodid(per);
					queyrCou.docomfirm();
					lvcourseInfo = queyrCou.getCourseInfos();
					Courselv.clear();
					lv.setAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1, Courselv));
					for (courseInfo courseInfo1 : lvcourseInfo) {
						String str = courseInfo1.getCoursename();
						Courselv.add(str);
					}
					lv.setAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1, Courselv));

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
