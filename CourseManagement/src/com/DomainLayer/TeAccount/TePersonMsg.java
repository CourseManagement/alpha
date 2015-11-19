package com.DomainLayer.TeAccount;

import net.sf.json.JSONObject;

import com.DUtils.userID;
import com.DataLayer.CountManagementModule.fixClass;
import com.DataLayer.CountManagementModule.queryClass;
import com.control.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TePersonMsg extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.teacher);
		userID ID = (userID) getApplication();

		final TextView username = (TextView) this.findViewById(R.id.username);
		final EditText password = (EditText) this.findViewById(R.id.password_edit);
		final EditText name = (EditText) this.findViewById(R.id.name_edit);
		final EditText major = (EditText) this.findViewById(R.id.major_edit);
		final EditText mail = (EditText) this.findViewById(R.id.mail_edit);
		final EditText phone = (EditText) this.findViewById(R.id.phone_edit);
		final EditText sex = (EditText) this.findViewById(R.id.sex_edit);
		final EditText birth = (EditText) this.findViewById(R.id.birthday_edit);
		// 返回服务端信息并显示
		queryClass query = new queryClass();
		query.setFlag("3");
		query.setUser_name(ID.getID());
		query.doComfirm();
		String jsonstr = query.getReturn_arr().toString();
		JSONObject json = JSONObject.fromObject(jsonstr);
		username.setText(json.getString("user_name"));
		password.setText(json.getString("password"));
		name.setText(json.getString("name"));
		major.setText(json.getString("department"));
		mail.setText(json.getString("email"));
		phone.setText(json.getString("telephone"));
		sex.setText(json.getString("sex"));
		birth.setText(json.getString("birthday"));
		password.setSelection(json.getString("password").length());// 设置光标位置为末尾
		
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
					Toast.makeText(TePersonMsg.this, "修改成功！", Toast.LENGTH_LONG).show();
					
				} else {
					Toast.makeText(TePersonMsg.this, "修改失败！", Toast.LENGTH_LONG).show();

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
