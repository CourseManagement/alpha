package com.DomainLayer.Account;

import net.sf.json.JSONObject;

import com.DataLayer.CountManagementModule.fixClass;
import com.DataLayer.CountManagementModule.queryClass;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Teacher extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.teacher);

		final TextView username = (TextView) this.findViewById(R.id.username);
		final EditText password = (EditText) this.findViewById(R.id.password_edit);
		final EditText name = (EditText) this.findViewById(R.id.name_edit);
		final EditText major = (EditText) this.findViewById(R.id.major_edit);
		final EditText mail = (EditText) this.findViewById(R.id.mail_edit);
		final EditText phone = (EditText) this.findViewById(R.id.phone_edit);
		final EditText sex = (EditText) this.findViewById(R.id.sex_edit);
		final EditText birth = (EditText) this.findViewById(R.id.birthday_edit);

		Intent intent = getIntent();
		username.setText(intent.getStringExtra("username"));
		password.setText(intent.getStringExtra("password"));
		name.setText(intent.getStringExtra("name"));
		major.setText(intent.getStringExtra("department"));
		mail.setText(intent.getStringExtra("email"));
		phone.setText(intent.getStringExtra("telephone"));
		sex.setText(intent.getStringExtra("sex"));
		birth.setText(intent.getStringExtra("birthday"));
		password.setSelection(intent.getStringExtra("password").length());// 设置光标位置为末尾
		
		Button cgmsg;
		Button fanh;
		cgmsg = (Button) this.findViewById(R.id.title_acomplish);
		fanh = (Button) this.findViewById(R.id.title_cancel);
		cgmsg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fixClass fix = new fixClass();
				JSONObject js = new JSONObject();
				fix.setFlag("3");
				js.put("user_name", username.getText().toString());
				js.put("password", password.getText().toString());
				js.put("name", name.getText().toString());
				js.put("department", major.getText().toString());
				js.put("email", mail.getText().toString());
				js.put("telephone", phone.getText().toString());
				js.put("sex", sex.getText().toString());
				js.put("birthday", birth.getText().toString());
				fix.setjsonObject(js);
				fix.doComfirm();
				if (fix.getReturn_flag().equals("y3")) {
					Toast.makeText(Teacher.this, "修改成功！", Toast.LENGTH_LONG).show();
					
				} else {
					Toast.makeText(Teacher.this, "修改失败！", Toast.LENGTH_LONG).show();

				}

			}
		});
		fanh.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				onBackPressed();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right); // 切换动画
				

			}
		});
		
		
	}

}
