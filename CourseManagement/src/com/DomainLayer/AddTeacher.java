package com.DomainLayer;

import com.DUtils.FileUtils;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class AddTeacher extends Activity {

	private static final int FILE_SELECT_CODE = 1;

	private Button tableimportBt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addteacher);

		tableimportBt = (Button) findViewById(R.id.tableimport);
		tableimportBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {// 选取文件，读取excel
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
				readExcelAndInsert(path);////读取信息，并插入
			}
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void readExcelAndInsert(String path) {//读取信息，并插入

	}

}
