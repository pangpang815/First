package com.jin.first;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingsActivity extends Activity {

	TextView textView2, textView3;
	CheckBox checkbox1, checkbox2;
	RadioGroup group1;
	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		textView2 = (TextView) findViewById(R.id.TextView02);
		textView3 = (TextView) findViewById(R.id.textView03);
		
		checkbox1 = (CheckBox) findViewById(R.id.CheckBox01);
		checkbox1.setOnClickListener(checkboxListener);
		
		checkbox2 = (CheckBox) findViewById(R.id.CheckBox02);
		checkbox2.setOnClickListener(checkboxListener);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(buttonListener);
		
		group1 = (RadioGroup) findViewById(R.id.RadioGroup01);
		group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId != -1) {
					RadioButton rBtn = (RadioButton) findViewById(checkedId);
					
					if (rBtn != null) {
						textView3.setText("sex :  " + rBtn.getText());
					}
				} else
					textView3.setText("sex : none ");
			}
		});
	}

	OnClickListener checkboxListener = new OnClickListener() {
		public void onClick (View view) {
			StringBuilder sb = new StringBuilder("category : ");
					
			if (checkbox1.isChecked()) {
				sb.append(checkbox1.getText().toString()).append(", ");
			}
			
			if (checkbox2.isChecked()) {
				sb.append(checkbox2.getText().toString()).append(", ");
			}
			
			textView2.setText(sb.toString());
		}
	};
	
	OnClickListener buttonListener = new OnClickListener() {
		public void onClick(View view) {
			group1.clearCheck();
			//checkbox reset하는 방법도 찾아보기!
		}
	};
}
