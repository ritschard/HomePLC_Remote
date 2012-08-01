package com.appldsp.homeplc;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class HomePLCRemoteApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		Editor editor = preferences.edit();
		editor.putString("hostAddress", "192.168.1.8");
		editor.putInt("hostPort", 1000);
		editor.putBoolean("autoSync", false);
		editor.putInt("autoSyncInterval", 1000);
		editor.putString("inputBoard", "analog");
		editor.putString("outputBoard", "digital");
		editor.commit();
		
		
	}

}
