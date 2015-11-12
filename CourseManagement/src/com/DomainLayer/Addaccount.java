package com.DomainLayer;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.TabHost;

import com.control.R;

public class Addaccount extends TabActivity  {
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.addaccount);

            Resources res = getResources(); // Resource object to get Drawables
            TabHost tabHost = getTabHost();  // The activity TabHost
            TabHost.TabSpec spec;  // Resusable TabSpec for each tab
            Intent intent;  // Reusable Intent for each tab

            // Create an Intent to launch an Activity for the tab (to be reused)
            intent = new Intent().setClass(this, AddXmanage.class);

            // Initialize a TabSpec for each tab and add it to the TabHost
            spec = tabHost.newTabSpec("ϵ������").setIndicator("ϵ������",
                              res.getDrawable(R.drawable.ic_tab_xmanage))
                          .setContent(intent);
            tabHost.addTab(spec);

            // Do the same for the other tabs
            intent = new Intent().setClass(this, AddTeacher.class);
            spec = tabHost.newTabSpec("��ʦ").setIndicator("��ʦ",
                              res.getDrawable(R.drawable.ic_tab_teacher))
                          .setContent(intent);
            tabHost.addTab(spec);


            tabHost.setCurrentTab(2);
        }
        @Override
    	public boolean onCreateOptionsMenu(Menu menu) {
    		// Inflate the menu; this adds items to the action bar if it is present.
    		getMenuInflater().inflate(R.menu.main, menu);
    		return true;
        }

}