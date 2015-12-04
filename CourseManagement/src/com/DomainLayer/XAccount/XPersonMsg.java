package com.DomainLayer.XAccount;
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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class XPersonMsg extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.xmanage);
		userID ID = (userID) getApplication();
		
		final TextView username = (TextView) this.findViewById(R.id.username1);
		final EditText password = (EditText) this.findViewById(R.id.password_edit1);
		final EditText major = (EditText) this.findViewById(R.id.major_edit1);

		// 返回服务端信息并显示
				queryClass query = new queryClass();
				query.setFlag("2");
				query.setUser_name(ID.getID());
				query.doComfirm();
				String jsonstr = query.getReturn_arr().toString();
				JSONObject json = JSONObject.fromObject(jsonstr);
		username.setText(json.getString("user_name"));
		password.setText(json.getString("password"));
		major.setText(json.getString("department"));
		password.setSelection(json.getString("password").length());// 设置光标位置为末尾
		
		ImageButton cgmsg;
		ImageButton fanh;
		cgmsg = (ImageButton) this.findViewById(R.id.title_acomplish1);
		fanh = (ImageButton) this.findViewById(R.id.title_cancel);
		cgmsg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fixClass fix = new fixClass();
				JSONObject js = new JSONObject();
				fix.setFlag("2");
				js.put("user_name", username.getText().toString());
				js.put("password", password.getText().toString());
				js.put("department", major.getText().toString());
				fix.setjsonObject(js);
				fix.doComfirm();
				if (fix.getReturn_flag().equals("y2")) {
					Toast.makeText(XPersonMsg.this, "修改成功！", Toast.LENGTH_LONG).show();
					
				} else {
					Toast.makeText(XPersonMsg.this, "修改失败！", Toast.LENGTH_LONG).show();

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
