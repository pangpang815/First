package com.jin.first;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
		setContentView(R.layout.linear);
		
		TextView textView01 = (TextView)findViewById(R.id.TextView01);
		String text = textView01.getText().toString();
		TextView textView02 = (TextView)findViewById(R.id.TextView02);
		textView02.setText(text);
		
		ImageView imageView02 = (ImageView)findViewById(R.id.ImageView02);
		imageView02.setImageResource(R.drawable.sample_2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_android, menu);
		return true;
	}

}
