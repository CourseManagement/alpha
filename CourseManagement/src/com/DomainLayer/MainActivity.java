package com.DomainLayer;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.DUtils.CheckNet;
import com.DUtils.userID;
import com.DataLayer.loginClass;
import com.control.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText acct = (EditText) findViewById(R.id.userNameText);
		final EditText passwd = (EditText) findViewById(R.id.passwdText);

		Button Login;
		Login = (Button) findViewById(R.id.bnLogin);
		Login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final String username = acct.getText().toString();
				final String pswd = passwd.getText().toString();

				if (TextUtils.isEmpty(acct.getText())
						|| TextUtils.isEmpty(passwd.getText())) {

					Toast.makeText(MainActivity.this, "用户名或密码不能为空！", 200)
							.show();

				} else if (username.contains("\"") || pswd.contains("\"")) {

					Toast.makeText(MainActivity.this, "请检查输入信息是否正确！", 200)
							.show();

				} else {
//					CheckNet checkNet = new CheckNet(
//							getApplicationContext(),
//							(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));
//					if (checkNet.checknet()) {
//						String reString = "";
//						loginClass login = new loginClass();
//						login.setUsername(username);
//						login.setPswd(pswd);
//						login.doComfirm();
//						reString = login.getResult();
						userID ID=(userID)getApplication();
						ID.setID("hello");
//						if (reString.equals("y1")) {
							Intent intent = new Intent();
							intent.setClass(MainActivity.this, MainManage.class);
							startActivity(intent);
//						}
//						if (reString.equals("y2")) {
//
//						} else if (reString.equals("y3")) {
//
//						} else if (reString.equals("n2")) {
//							Toast.makeText(MainActivity.this, "数据库连接错误！",
//									Toast.LENGTH_LONG).show();
//						} else if (reString.equals("n4")) {
//							Toast.makeText(MainActivity.this, "用户不存在！",
//									Toast.LENGTH_LONG).show();
//						}
//					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
