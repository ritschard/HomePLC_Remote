package com.appldsp.homeplc;

import org.json.JSONArray;
import org.json.JSONException;

import com.appldsp.homeplc.R.id;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class AnalogInputsActivity extends Activity {

	private SharedPreferences preferences;
	private AsyncHttpClient client;
	private Timer timer;
	
	private ProgressBar bar1;
	private ProgressBar bar2;
	private ProgressBar bar3;
	private ProgressBar bar4;
	private ProgressBar bar5;
	private ProgressBar bar6;
	
	private TextView val1;
	private TextView val2;
	private TextView val3;
	private TextView val4;
	private TextView val5;
	private TextView val6;
	
	private int getLoadColor(int val)
	{
		int result = Color.WHITE;
	
		if (val >= 10 && val < 72 ) 
			result = Color.GREEN;
		
		else if (val > 72 && val < 135 )
			result = Color.YELLOW;
		
		else if (val >= 135 && val < 195 )
			result = Color.rgb(255, 140, 0);
		
		else if (val >= 195 && val < 256 )
			result = Color.RED;
		
		return result;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analog_inputs);
		
		preferences = PreferenceManager.getDefaultSharedPreferences(this);    
		client = new AsyncHttpClient();
		
		timer = new Timer();
		
		bar1 = (ProgressBar) findViewById(id.analogInputBar1);
		bar2 = (ProgressBar) findViewById(id.analogInputBar2);
		bar3 = (ProgressBar) findViewById(id.analogInputBar3);
		bar4 = (ProgressBar) findViewById(id.analogInputBar4);
		bar5 = (ProgressBar) findViewById(id.analogInputBar5);
		bar6 = (ProgressBar) findViewById(id.analogInputBar6);
		
		val1 = (TextView) findViewById(id.analogInputVal1);
		val2 = (TextView) findViewById(id.analogInputVal2);
		val3 = (TextView) findViewById(id.analogInputVal3);
		val4 = (TextView) findViewById(id.analogInputVal4);
		val5 = (TextView) findViewById(id.analogInputVal5);
		val6 = (TextView) findViewById(id.analogInputVal6);
		
		getAllData();
		
		timer.scheduleAtFixedRate(new TimerTask() { 
		    	
		    	@Override
		   	public void run() {
		   		// TODO Auto-generated method stub
		   		getAllData();
		   	}
		    	
		}, 0, 1000);
		
		
		
	}
	
	private void getAllData() {
		
		client.get(getApsoluteUri("GetAnalogInputs"), new AsyncHttpResponseHandler() { 
				
			@Override
			public void onSuccess(String arg0) {
				super.onSuccess(arg0);
				int[] values;
			
				JSONArray arr = new JSONArray();
			
				try {
					arr = new JSONArray(arg0);										
				} catch (JSONException e) {
				e.printStackTrace();
			}
			
			values = new int[arr.length()];
			
			for (int i = 0; i < arr.length(); i++) {
				try {
					values[i] = Integer.parseInt(arr.getString(i));
				} catch (JSONException e) {
						e.printStackTrace();
					}
			}
									
			bar1.setProgress(values[0]);
			String v1 = String.valueOf(values[0]);
			val1.setText(v1);
			val1.setTextColor(getLoadColor(values[0]));
			
			bar2.setProgress(values[1]);
			String v2 = String.valueOf(values[1]);
			val2.setText(v2);
			val2.setTextColor(getLoadColor(values[1]));
			
			bar3.setProgress(values[2]);
			String v3 = String.valueOf(values[2]);
			val3.setText(v3);
			val3.setTextColor(getLoadColor(values[2]));
			
			bar4.setProgress(values[3]);
			String v4 = String.valueOf(values[3]);
			val4.setText(v4);
			val4.setTextColor(getLoadColor(values[3]));
			
			bar5.setProgress(values[4]);
			String v5 = String.valueOf(values[4]);
			val5.setText(v5);
			val5.setTextColor(getLoadColor(values[4]));
			
			bar6.setProgress(values[5]);
			String v6 = String.valueOf(values[5]);
			val6.setText(v6);
			val6.setTextColor(getLoadColor(values[5]));
			
			}				
					
				
			});
			
		}
	
		public void TimerMethod() {
		    runOnUiThread(new Runnable() {
		    	
		        public void run() {
		            
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
