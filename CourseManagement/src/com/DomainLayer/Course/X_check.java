package com.DomainLayer.Course;

import com.control.R;

import android.R.anim;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class X_check extends Activity {
	
	
	//这里修改成相应的数据库数据，这里的data是测试时用的
	
	private String[]data={"Apple","Banana","Orange","Watermelon","Pear","Grape",
			"Pineapple","Strawberry","Cherry","Mango","a","b","c","d","e"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.x_check);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(
				X_check.this,android.R.layout.simple_list_item_1,
				data);
		ListView listview=(ListView)findViewById(R.id.courselist);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
