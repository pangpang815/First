package com.jin.first.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jin.first.R;

public class LoginActivity extends Activity {

	Button okBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		okBtn = (Button) findViewById(R.id.sign_ok);
		okBtn.setOnClickListener(okListener);		
	}
	
	OnClickListener okListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.sign_ok:
					finish();	//호출 Activity로 되돌아감
					break;
			}
		}
	};
}
