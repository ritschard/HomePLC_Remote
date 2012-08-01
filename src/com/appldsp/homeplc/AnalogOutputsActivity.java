package com.appldsp.homeplc;

import com.appldsp.homeplc.R.id;
import com.appldsp.homeplc.R.string;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class AnalogOutputsActivity extends Activity {
	
	private SeekBar bar1;
	private SeekBar bar2;
	private SeekBar bar3;
	private SeekBar bar4;
	private SeekBar bar5;
	private SeekBar bar6;
	
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
	
	private OnSeekBarChangeListener onSeekBarChangeListener = new OnSeekBarChangeListener() {
		
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}
		
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			
			int color = getLoadColor(progress);
			
			switch (seekBar.getId()) {
			
			case R.id.analogOutputBar1:
				val1.setText(Integer.toString(progress));
				val1.setTextColor(color);
				break;

			case R.id.analogOutputBar2:
				val2.setText(Integer.toString(progress));
				val2.setTextColor(color);
				break;
				
			case R.id.analogOutputBar3:
				val3.setText(Integer.toString(progress));
				val3.setTextColor(color);
				break;
				
			case R.id.analogOutputBar4:
				val4.setText(Integer.toString(progress));
				val4.setTextColor(color);
				break;
				
			case R.id.analogOutputBar5:
				val5.setText(Integer.toString(progress));
				val5.setTextColor(color);
				break;
				
			case R.id.analogOutputBar6:
				val6.setText(Integer.toString(progress));
				val6.setTextColor(color);
				break;
				
			default:
				break;
			}
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_analog_outputs);
		
		bar1 = (SeekBar) findViewById(R.id.analogOutputBar1);
		bar1.setOnSeekBarChangeListener(onSeekBarChangeListener);
		
		bar2 = (SeekBar) findViewById(R.id.analogOutputBar2);
		bar2.setOnSeekBarChangeListener(onSeekBarChangeListener);
		
		bar3 = (SeekBar) findViewById(R.id.analogOutputBar3);
		bar3.setOnSeekBarChangeListener(onSeekBarChangeListener);
		
		bar4 = (SeekBar) findViewById(R.id.analogOutputBar4);
		bar4.setOnSeekBarChangeListener(onSeekBarChangeListener);
		
		bar5 = (SeekBar) findViewById(R.id.analogOutputBar5);
		bar5.setOnSeekBarChangeListener(onSeekBarChangeListener);
		
		bar6 = (SeekBar) findViewById(R.id.analogOutputBar6);
		bar6.setOnSeekBarChangeListener(onSeekBarChangeListener);
		
		val1 = (TextView) findViewById(R.id.analogOutputVal1);
		val1.setText(Integer.toString(bar1.getProgress()));
		
		val2 = (TextView) findViewById(R.id.analogOutputVal2);
		val2.setText(Integer.toString(bar2.getProgress()));
		
		val3 = (TextView) findViewById(R.id.analogOutputVal3);
		val3.setText(Integer.toString(bar3.getProgress()));
		
		val4 = (TextView) findViewById(R.id.analogOutputVal4);
		val4.setText(Integer.toString(bar4.getProgress()));
		
		val5 = (TextView) findViewById(R.id.analogOutputVal5);
		val5.setText(Integer.toString(bar5.getProgress()));
		
		val6 = (TextView) findViewById(R.id.analogOutputVal6);
		val6.setText(Integer.toString(bar6.getProgress()));
						
		
		
	}

}
