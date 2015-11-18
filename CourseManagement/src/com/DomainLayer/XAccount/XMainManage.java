package com.DomainLayer.XAccount;

import com.DUtils.CheckNet;
import com.DomainLayer.Account.AccountInformation;
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

public class XMainManage extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainmanage);

		Button manage;
		ImageButton permsg;
		ImageButton fanh;
		Button course;
		course = (Button) this.findViewById(R.id.course);
		manage = (Button) this.findViewById(R.id.account);
		permsg = (ImageButton) this.findViewById(R.id.person);
		fanh = (ImageButton) this.findViewById(R.id.back);
		// 跳转账号管理界面
		manage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 检查是否联网
				CheckNet checkNet = new CheckNet(
						getApplicationContext(),
						(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));
				
				if (checkNet.checknet()) {
					Intent intent = new Intent();
					intent.setClass(XMainManage.this, AccountInformation.class);
					startActivity(intent);
					overridePendingTransition(R.anim.in_from_right,
							R.anim.out_to_left); // 切换动画
				}

			}
		});
		// 跳转个人信息界面
		permsg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 检查是否联网
				CheckNet checkNet = new CheckNet(
						getApplicationContext(),
						(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));
				
				if (checkNet.checknet()) {
				Intent intent = new Intent();
				intent.setClass(XMainManage.this, XPersonMsg.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left); // 切换动画
				}

			}
		});
		course.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 检查是否联网
				CheckNet checkNet = new CheckNet(
						getApplicationContext(),
						(ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE));
				
				if (checkNet.checknet()) {
				Intent intent = new Intent();
				intent.setClass(XMainManage.this, Ccoursemage.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left); // 切换动画
				}

			}
		});
		//返回上一级
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
