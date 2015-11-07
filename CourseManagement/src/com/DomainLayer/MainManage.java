package com.DomainLayer;

import com.DUtils.userID;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainManage extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmanage);
		
		Button manage;
		Button permsg;
		manage=(Button)findViewById(R.id.account);
		permsg=(Button)findViewById(R.id.pmsg);
		//跳转账号管理界面
		manage.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(MainManage.this, AccountInformation.class);
	        	startActivity(intent);
	        	overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left); //切换动画
	        	
	        }
	    });
		//跳转个人信息界面
		permsg.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(MainManage.this, PersonMsg.class);
	        	startActivity(intent);
	        	overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left); //切换动画
	        	
	        }
	    });
	}
}
