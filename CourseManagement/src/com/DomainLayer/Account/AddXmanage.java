package com.DomainLayer.Account;

import com.DataLayer.CountManagementModule.addCounts;
import com.DataLayer.Model.departmentmanager;
import com.control.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddXmanage extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addxmanage);
		
		final TextView user = (TextView) this.findViewById(R.id.userID_edit);
		final TextView ps = (TextView) this.findViewById(R.id.password_edit);
		final TextView na = (TextView) this.findViewById(R.id.major_spinner);
		Button add = (Button) this.findViewById(R.id.makesure);
		Button ret = (Button) this.findViewById(R.id.reset);
		
		add.setOnClickListener(new OnClickListener() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick(View v) {

				departmentmanager itdepar = new departmentmanager();
				itdepar.setUser_name(user.getText().toString());
				itdepar.setPassword(ps.getText().toString());
				itdepar.setDepartment(na.getText().toString());
				addCounts addc = new addCounts();
				addc.setDepartmentmanager(itdepar);
				addc.setFlag("1");
				String flag = addc.doComfirm();
				if (flag.equals("y1")) {
					Toast.makeText(getApplicationContext(), "添加成功！", 200).show();

				} else if (flag.equals("n1")) {
					Toast.makeText(getApplicationContext(), "添加失败！", 200).show();

				} 
				//TODO “n2”未知错误；“n3”json格式错误
			}
		});
		ret.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				user.setText("");
				ps.setText("");
				na.setText("");
				
			}
		});
	}

}
