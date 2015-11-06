package com.DomainLayer;

import net.sf.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.DataLayer.fixClass;
import com.DataLayer.queryClass;
import com.control.R;

public class PersonMsg extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personmsg);

		final EditText edtName;
		final EditText edtPsd;
		final EditText edtPh;
		final TextView username;
		username = (TextView) findViewById(R.id.textusername);
		edtPsd = (EditText) findViewById(R.id.edtpsd);
		edtName = (EditText) findViewById(R.id.edtname);
		edtPh = (EditText) findViewById(R.id.edtph);
		//返回服务端信息并显示
		queryClass query = new queryClass();
		query.setFlag("1");
		query.setUser_name("y1");
		query.doComfirm();
		String jsonstr = query.getReturn_arr().toString();
		JSONObject json = JSONObject.fromObject(jsonstr);
		username.setText(json.getString("user_name"));
		edtPsd.setText(json.getString("password"));
		edtName.setText(json.getString("name"));
		edtPh.setText(json.getString("telephone"));
		edtPsd.setSelection(json.getString("password").length());//设置光标位置为末尾

		//提交修改信息
		Button cgmsg;
		cgmsg = (Button) findViewById(R.id.btchange);
		cgmsg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fixClass fix = new fixClass();
				JSONObject js = new JSONObject();
				fix.setFlag("1");
				js.put("user_name", username.getText().toString());
				js.put("name", edtName.getText().toString());
				js.put("password", edtPsd.getText().toString());
				js.put("telephone", edtPh.getText().toString());
				fix.setjsonObject(js);
				fix.doComfirm();
				Toast.makeText(PersonMsg.this, "修改成功！", Toast.LENGTH_LONG).show();

			}
		});

	}

}
