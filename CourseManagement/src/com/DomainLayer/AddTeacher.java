package com.DomainLayer;

import java.util.ArrayList;
import java.util.List;

import com.DUtils.FileUtils;
import com.DataLayer.addCounts;
import com.DataLayer.Model.teacher;
import com.DataLayer.Runnable.getInfoFromExcel;
import com.control.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddTeacher extends Activity {

	private static final int FILE_SELECT_CODE = 1;

	private Button tableimportBt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addteacher);

		final TextView user = (TextView) findViewById(R.id.gongID_edit);
		final TextView ps = (TextView) findViewById(R.id.init_password_edit);
		final TextView na = (TextView) findViewById(R.id.name_edit);
		Button add = (Button) findViewById(R.id.make_sure);

		add.setOnClickListener(new OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {

				List<teacher> teach = new ArrayList();
				teacher itteacher = new teacher();
				itteacher.setUser_name(user.getText().toString());
				itteacher.setPassword(ps.getText().toString());
				itteacher.setName(na.getText().toString());
				teach.add(itteacher);
				addCounts addc = new addCounts();
				addc.setTeachers(teach);
				addc.setFlag("2");
				String flag = addc.doComfirm();
				if (flag.equals("y1")) {
					Toast.makeText(getApplicationContext(), "��ӳɹ���", 200)
							.show();

				} else if (flag.equals("n1")) {
					Toast.makeText(getApplicationContext(), "���ʧ�ܣ�", 200)
							.show();

				}
				// TODO ��n2��δ֪���󣻡�n3��json��ʽ����
			}
		});

		tableimportBt = (Button) findViewById(R.id.tableimport);
		tableimportBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {// ѡȡ�ļ�����ȡexcel
				// TODO Auto-generated method stub

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
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case FILE_SELECT_CODE:
			if (resultCode == RESULT_OK) {
				// Get the Uri of the selected file
				Uri uri = data.getData();
				String path = FileUtils.getPath(this, uri);
				Log.i("filepath", path);
				getInfoFromExcel getInfoFromExcel = new getInfoFromExcel();
				getInfoFromExcel.setPath(path);
				getInfoFromExcel.run();
				try {
					getInfoFromExcel.join();
					System.out.println(getInfoFromExcel.getResult());//����״̬��ʶ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
