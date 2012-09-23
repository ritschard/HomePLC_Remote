package com.appldsp.homeplc;

import com.appldsp.homeplc.R.id;

import android.R.color;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DigitalOutputsActivity extends Activity {

	private SharedPreferences preferences;
	private AsyncHttpClient client;
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	
	private OnClickListener listener = new OnClickListener() {
		
		public void onClick(View v) {
			
			final Button btn = (Button) v;
			
			boolean check = false;
									
			switch (v.getId()) {
			case id.toggleButton1:
				
				if (btn1.getText() == "OFF")
					check = true;  
				else
					check = false;
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 0 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {
						super.onSuccess(result);
																		
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn1.setText("ON");
							btn1.setTextColor(Color.GREEN);
						}
						else
						{
							btn1.setText("OFF");
							btn1.setTextColor(Color.RED);
						}
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn1.refreshDrawableState();
						
					};
					
				});
				
				break;
				
			case id.toggleButton2:
				
				if (btn2.getText() == "OFF")
					check = true;  
				else
					check = false;
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 1 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {
	
						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn2.setText("ON");
							btn2.setTextColor(Color.GREEN);
						}
						else
						{
							btn2.setText("OFF");
							btn2.setTextColor(Color.RED);
						}
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn2.refreshDrawableState();
						
					};
					
				});
				
				break;
			
			case id.toggleButton3:
				
				String txt = (String) btn3.getText();
				if (txt == "OFF")
					check = true;  
				else
					check = false;
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 2 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {
	
						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn3.setText("ON");
							btn3.setTextColor(Color.GREEN);
						}
						else
						{
							btn3.setText("OFF");
							btn3.setTextColor(Color.RED);
						}
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn3.refreshDrawableState();
						
					};
				});
				
				break;
				
			case id.toggleButton4:
				
				if (btn4.getText() == "OFF")
					check = true;  
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 3 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {
	
						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn4.setText("ON");
							btn4.setTextColor(Color.GREEN);
						}
						else
						{
							btn4.setText("OFF");
							btn4.setTextColor(Color.RED);
						}
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn4.refreshDrawableState();
						
					};
				});
				
				break;
			
			case id.toggleButton5:
				
				if (btn5.getText() == "OFF")
					check = true;  
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 4 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {

						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn5.setText("ON");
							btn5.setTextColor(Color.GREEN);
						}
						else
						{
							btn5.setText("OFF");
							btn5.setTextColor(Color.RED);
						}
						
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn5.refreshDrawableState();
						
					};
				});
				
				break;
				
			case id.toggleButton6:
				
				if (btn6.getText() == "OFF")
					check = true;  
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 5 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {

						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn6.setText("ON");
							btn6.setTextColor(Color.GREEN);
						}
						else
						{
							btn6.setText("OFF");
							btn6.setTextColor(Color.RED);
						}
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn6.refreshDrawableState();
						
					};
				});
				
				break;
			
			case id.toggleButton7:
				
				if (btn7.getText() == "OFF")
					check = true;  
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 6 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {
						
						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn7.setText("ON");
							btn7.setTextColor(Color.GREEN);
						}
						else
						{
							btn7.setText("OFF");
							btn7.setTextColor(Color.RED);
						}
					}
					
					@Override
					public void onFailure(Throwable arg0) {
						btn7.refreshDrawableState();
						
					};
					
				});
				
				break;
				
			case id.toggleButton8:
				
				if (btn8.getText() == "OFF")
					check = true;  
				
				client.get(getApsoluteUri("SetDigitalOutput/" + 7 + "/" + check), new AsyncHttpResponseHandler() { 
					
					@Override
					public void onSuccess(String result) {
	
						super.onSuccess(result);
						boolean res = Boolean.parseBoolean(result);
						
						if (res)
						{
							btn8.setText("ON");
							btn8.setTextColor(Color.GREEN);
						}
						else
						{
							btn8.setText("OFF");
							btn8.setTextColor(Color.RED);
						}
					}	
					
					@Override
					public void onFailure(Throwable arg0) {
						btn8.refreshDrawableState();
						
					};
				});
				
				break;
				
			default:
				break;
			}
			
		}
	}; 
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_digital_outputs);
		
		preferences = PreferenceManager.getDefaultSharedPreferences(this);    
		
		client = new AsyncHttpClient();
		
	    btn1 = (Button) findViewById(id.toggleButton1);
	    btn1.setOnClickListener(listener);
	    btn2 = (Button) findViewById(id.toggleButton2);
	    btn2.setOnClickListener(listener);
	    btn3 = (Button) findViewById(id.toggleButton3);
	    btn3.setOnClickListener(listener);
	    btn4 = (Button) findViewById(id.toggleButton4);
	    btn4.setOnClickListener(listener);
	    btn5 = (Button) findViewById(id.toggleButton5);
	    btn5.setOnClickListener(listener);
	    btn6 = (Button) findViewById(id.toggleButton6);
	    btn6.setOnClickListener(listener);
	    btn7 = (Button) findViewById(id.toggleButton7);
	    btn7.setOnClickListener(listener);
	    btn8 = (Button) findViewById(id.toggleButton8);
	    btn8.setOnClickListener(listener);
	    
	    getAllData();
	}
	
	
	
	private void getAllData() {
		
		client.get(getApsoluteUri("GetDigitalOutputs"), new AsyncHttpResponseHandler() { 
						
			@Override
			public void onSuccess(String arg0) {
				// TODO Auto-generated method stub
				super.onSuccess(arg0);
				boolean[] values;
				
				JSONArray arr = new JSONArray();
				
				try {
					arr = new JSONArray(arg0);										
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				values = new boolean[arr.length()];
				
				for (int i = 0; i < arr.length(); i++) {
					try {
						values[i] = Boolean.parseBoolean(arr.getString(i));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (values[0])	{
					btn1.setText("ON");
					btn1.setTextColor(Color.GREEN);
				}
				else {
					btn1.setText("OFF");
					btn1.setTextColor(Color.RED);
				}
				
				if (values[1])	{
					btn2.setText("ON");
					btn2.setTextColor(Color.GREEN);
				}
				else {
					btn2.setText("OFF");
					btn2.setTextColor(Color.RED);
				}
				
				if (values[2])	{
					btn3.setText("ON");
					btn3.setTextColor(Color.GREEN);
				}
				else {
					btn3.setText("OFF");
					btn3.setTextColor(Color.RED);
				}
				
				if (values[3])	{
					btn4.setText("ON");
					btn4.setTextColor(Color.GREEN);
				}
				else {
					btn4.setText("OFF");
					btn4.setTextColor(Color.RED);
				}
				
				if (values[4])	{
					btn5.setText("ON");
					btn5.setTextColor(Color.GREEN);
				}
				else {
					btn5.setText("OFF");
					btn5.setTextColor(Color.RED);
				}
				
				if (values[5])	{
					btn6.setText("ON");
					btn6.setTextColor(Color.GREEN);
				}
				else {
					btn6.setText("OFF");
					btn6.setTextColor(Color.RED);
				}
				
				if (values[6])	{
					btn7.setText("ON");
					btn7.setTextColor(Color.GREEN);
				}
				else {
					btn7.setText("OFF");
					btn7.setTextColor(Color.RED);
				}
				
				if (values[7])	{
					btn8.setText("ON");
					btn8.setTextColor(Color.GREEN);
				}
				else {
					btn8.setText("OFF");
					btn8.setTextColor(Color.RED);
				}
			}
			
		});
		
	}

	
	private boolean setAnalogOutput(int pin, byte value) {
		
		boolean result = false;
		
		client.get(getApsoluteUri("SetAnalogOutput/" + pin + "/" + value), new AsyncHttpResponseHandler() { 
			
			@Override
			public void onSuccess(String arg0) {
				// TODO Auto-generated method stub
				super.onSuccess(arg0);
				
			}
				
		});
		
		
		return result;
	}
	
	private String getApsoluteUri(String relativeUri) {
		
		String host = preferences.getString("prefHostAddress", null);
		String port = preferences.getString("prefPort", null);
		String endpoint = "HomePLCRemoteService";
		
		return "http://" + host + ":" + port + "/" + endpoint + "/" + relativeUri; 
		
	}
}
