package com.DomainLayer.TeAccount;

import com.DUtils.CheckNet;
import com.DomainLayer.Account.AccountInformation;
import com.DomainLayer.Account.MainManage;
import com.DomainLayer.Account.PersonMsg;
import com.DomainLayer.Course.Ccoursemage;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class TeMainManage extends Activity{
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.te_main);
		Button past;
		ImageButton te_information;
		ImageButton fanh;
		te_information=(ImageButton)this.findViewById(R.id.te_information);
		fanh=(ImageButton) findViewById(R.id.te_back);
		past=(Button) findViewById(R.id.te_histr);
		
				// ��ת������Ϣ����
		te_information.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// ����Ƿ�����
						CheckNet checkNet = new CheckNet(
								getApplicationContext(),
								(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));
						
						if (checkNet.checknet()) {
						Intent intent = new Intent();
						intent.setClass(TeMainManage.this, PersonMsg.class);
						startActivity(intent);
						overridePendingTransition(R.anim.in_from_right,
								R.anim.out_to_left); // �л�����
						}

					}
				});
				
				//������һ��
				fanh.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						
						onBackPressed();
						overridePendingTransition(android.R.anim.slide_in_left,
								android.R.anim.slide_out_right); // �л�����
						

					}
				});
			}
		
	    }

