package com.jin.first.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jin.first.R;

public class HelloAndroidActivity extends Activity {

	EditText entry;
	TextView print;
	Button okBtn;
	Button cancelBtn;
	Button finishBtn;
	Button nextBtn; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		entry = (EditText) findViewById(R.id.entry);
		print = (TextView) findViewById(R.id.print);
		
		okBtn = (Button) findViewById(R.id.OK);
		okBtn.setOnClickListener(okListener);
		
		cancelBtn = (Button) findViewById(R.id.cancel);
		cancelBtn.setOnClickListener(cancelListener);
		
		finishBtn = (Button) findViewById(R.id.finish);
		finishBtn.setOnClickListener(stopListener);
		
		nextBtn = (Button) findViewById(R.id.next);
		nextBtn.setOnClickListener(nextIntentListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_android, menu);
		return true;
	}
	
	OnClickListener okListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			print.setText(entry.getText());
		}
	};
	
	OnClickListener cancelListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			entry.setText("");
			print.setText("");
		}
	};
	
	OnClickListener stopListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
		}
	};
	
	OnClickListener nextIntentListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(HelloAndroidActivity.this, LoginActivity.class);
			
			//Activity 실행하기
			startActivity(intent);
		}
	};
}
