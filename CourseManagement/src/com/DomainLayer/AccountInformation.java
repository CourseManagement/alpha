package com.DomainLayer;

import com.control.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AccountInformation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_information);
		
		Button change1,change2,change3,change4;
		change1=(Button)findViewById(R.id.change1);
		change2=(Button)findViewById(R.id.change2);
		change3=(Button)findViewById(R.id.addteacher);
		change4=(Button)findViewById(R.id.addX);
		
		change1.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(AccountInformation.this, Xmanage.class);
	        	startActivity(intent);
	        	
	        }
	    });
		
		change2.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(AccountInformation.this, Teacher.class);
	        	startActivity(intent);
	        	
	        }
	    });
		
		change3.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(AccountInformation.this, AddTeacher.class);
	        	startActivity(intent);
	        	
	        }
	    });
		
		change4.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            //TODO jump
	        	Intent intent = new Intent();
	        	intent.setClass(AccountInformation.this, AddXmanage.class);
	        	startActivity(intent);
	        	
	        }
	    });

	}

}
