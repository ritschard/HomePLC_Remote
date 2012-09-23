package com.appldsp.homeplc;

import org.json.JSONArray;
import org.json.JSONException;

import com.appldsp.homeplc.R.id;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LogActivity extends Activity {

	private SharedPreferences preferences;
	private AsyncHttpClient client;
	private Button buttonRefresh;
	private EditText logEditTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		
		logEditTextView = (EditText) findViewById(id.logEditTextView);

		//getLog();
		
		buttonRefresh = (Button) findViewById(id.btnLogRefresh);
		buttonRefresh.setOnClickListener(listener);
		
		preferences = PreferenceManager.getDefaultSharedPreferences(this);    
		client = new AsyncHttpClient();
									
	}
	
	private OnClickListener listener = new OnClickListener() {
		
		public void onClick(View v) {
			getLog();
		}
	};
	
	private void getLog() {
		
		client.get(getApsoluteUri("GetLog"), new AsyncHttpResponseHandler() { 
			
			@Override
			public void onSuccess(String arg0) {
				super.onSuccess(arg0);
				
				JSONArray arr = new JSONArray();
				
				try {
					arr = new JSONArray(arg0);										
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				String[] vals = new String[arr.length()];
				
				for (int i = 0; i < arr.length(); i++) {
					try {
						vals[i] = arr.getString(i);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				for (int j = 0; j < vals.length; j++)
				{
					
					logEditTextView.append(vals[j] + "\n");					
				}
			}
		});
		
	}
	
	private String getApsoluteUri(String relativeUri) {
		
		String host = preferences.getString("prefHostAddress", null);
		String port = preferences.getString("prefPort", null);
		String endpoint = "HomePLCRemoteService";
		
		return "http://" + host + ":" + port + "/" + endpoint + "/" + relativeUri; 
		
	}
	
}
