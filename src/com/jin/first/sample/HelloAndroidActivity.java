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
			finish();
		}
	};
	
	OnClickListener nextIntentListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(HelloAndroidActivity.this, LoginActivity.class);
			
			// 데이터 (entry   testText) 송신
			// key(name):value 쌍으로 해쉬 테이블 (자료구조)
			intent.putExtra("text", entry.getText());
			intent.putExtra("activity", getClass().getName());
			
			//전송할 데이터가 여러 개 일 경우에는 번들(Bundle)에 상태정보를 저장한다.
			Bundle extras = new Bundle();
			extras.putString("text", entry.getText().toString());
			extras.putString("activity", getClass().getName());
			intent.putExtras(extras);
			
			//Activity 실행하기
			startActivityForResult(intent, 1);
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
		if (requestCode == 1) {
			if (resultCode == RESULT_CANCELED) {
				setTitle("Fail");
			} else {
				setTitle("success: return result value : " + data.getStringExtra("result"));
			}
		}
	}

}
