package com.DomainLayer;

import com.control.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddTeacher extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addteacher);
		Button add;
		add = (Button) findViewById(R.id.make_sure);
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
			}
	});
}
}
