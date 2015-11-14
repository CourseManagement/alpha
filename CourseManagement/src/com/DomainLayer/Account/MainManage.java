package com.DomainLayer.Account;

import com.DUtils.userID;
import com.DomainLayer.Course.Ccoursemage;
import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainManage extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainmanage);
		
		Button manage;
		ImageButton permsg;
		Button course;
		course = (Button) findViewById(R.id.course);
		manage=(Button)findViewById(R.id.account);
		permsg=(ImageButton)findViewById(R.id.person);
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
		course.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(MainManage.this, Ccoursemage.class);
	        	startActivity(intent);
	        	overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left); //切换动画
	        	
	        }
	    });
	}
}
