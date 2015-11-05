package com.DUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class CheckNet {

	public Context context;
	public ConnectivityManager connectivityManager;
	
	public CheckNet(Context context,ConnectivityManager connectivityManager){
		this.context = context;
		this.connectivityManager = connectivityManager;
	}

	
	public boolean checknet() {
		ConnectivityManager con = connectivityManager;
		boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.isConnectedOrConnecting();
		boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting();
		if (wifi | internet) {
			return true;
		} else {
			Toast.makeText(context, "Ç×£¬ÍøÂçÁ¬ÁËÃ´£¿", Toast.LENGTH_LONG)
					.show();
			return false;
		}

	}
	
	
	
}
