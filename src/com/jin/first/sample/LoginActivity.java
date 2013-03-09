package com.jin.first.sample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jin.first.R;

public class LoginActivity extends Activity {

	static final int REQ_DIAL = 1;
	static final int REQ_BROWSER = 1;
	
	Button okBtn;
	Button dialBtn;
	Button browserBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		okBtn = (Button) findViewById(R.id.sign_ok);
		okBtn.setOnClickListener(okListener);
		
		findViewById(R.id.dial).setOnClickListener(intentListener);
		findViewById(R.id.browser).setOnClickListener(intentListener);
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
	
	OnClickListener intentListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
				case R.id.dial:
					//액티비티 전환을 위한 인텐트
					intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));	//작업 지시서(인텐스)
					
					//요구 코드: 되돌아 왔을 때 어느 액티비티를 수행할 것인지 근거 마련
					startActivityForResult(intent, REQ_DIAL);
					break;
				case R.id.browser:
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
					startActivityForResult(intent, REQ_BROWSER);
					break;
			}
		}
	};
	
	/**
	 * 내가 호출한 액티비티가 종료되면 다시 돌아온다
	 * 
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		setTitle(String.valueOf(resultCode));
	}
}