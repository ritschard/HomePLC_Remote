package com.appldsp.homeplc;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SharedPreferences preferences = null;
	
	private OnSharedPreferenceChangeListener preferenceChangedListener = new OnSharedPreferenceChangeListener() {
		
		public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
			// TODO Auto-generated method stub
			
		}
	};
	
    private OnClickListener outputsButtonListener = new OnClickListener() {
		
		public void onClick(View v) {
									
			String boardType = preferences.getString("prefOutputBoardType", null);
			
			Toast.makeText(MainActivity.this, boardType, Toast.LENGTH_SHORT).show();
									
			if (boardType.equals("ANALOG")) {
				
				Intent intent = new Intent(MainActivity.this, AnalogOutputsActivity.class);
				startActivity(intent);
			} 
			
			if (boardType.equals("DIGITAL")) {
				
				Intent intent = new Intent(MainActivity.this, DigitalOutputsActivity.class);
				startActivity(intent);
			}
		}
		
	}; 
	
	private OnClickListener inputsButtonListener = new OnClickListener() {
			
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private OnClickListener logButtonListener = new OnClickListener() {
			
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        preferences = PreferenceManager.getDefaultSharedPreferences(this);     
        preferences.registerOnSharedPreferenceChangeListener(preferenceChangedListener);
                
        Button outputsButton = (Button) findViewById(R.id.btnOutputs);
        outputsButton.setOnClickListener(outputsButtonListener);
        
        Button inputsButton = (Button) findViewById(R.id.btnInputs);
        inputsButton.setOnClickListener(inputsButtonListener);
        
        Button logButton = (Button) findViewById(R.id.btnLog);
        logButton.setOnClickListener(logButtonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
		case R.id.settingsMenuItem:
			Intent intent = new Intent(MainActivity.this, PreferencesActivity.class);
			startActivity(intent);
		}    	
    	
    	return super.onOptionsItemSelected(item);
    }
    
}
