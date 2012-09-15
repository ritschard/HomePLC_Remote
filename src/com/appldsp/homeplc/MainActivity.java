package com.appldsp.homeplc;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import android.R.bool;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import org.restlet.*;

public class MainActivity extends Activity {
	
	private final static String SERVICE_URI = "http://192.168.1.2:8080/RemoteService";
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

	private OnClickListener connectButtonListener = new OnClickListener() {
		
		public void onClick(View v) {
			
			
		}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        preferences = PreferenceManager.getDefaultSharedPreferences(this);     
        preferences.registerOnSharedPreferenceChangeListener(preferenceChangedListener);
        
        Button connectButton = (Button) findViewById(R.id.btnConnect);
        connectButton.setOnClickListener(connectButtonListener);
        
        Button outputsButton = (Button) findViewById(R.id.btnOutputs);
        outputsButton.setOnClickListener(outputsButtonListener);
        
        Button inputsButton = (Button) findViewById(R.id.btnInputs);
        inputsButton.setOnClickListener(inputsButtonListener);
        
        Button logButton = (Button) findViewById(R.id.btnLog);
        logButton.setOnClickListener(logButtonListener);
    }

	@Override
	protected void onResume() {
	    super.onResume();
	    //refresh();
	    
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
    
    private void refresh() {
      
            
    }
    
}
