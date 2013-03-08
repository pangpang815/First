package com.jin.first.sample;

import com.jin.first.R;
import com.jin.first.R.drawable;
import com.jin.first.R.id;
import com.jin.first.R.layout;
import com.jin.first.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity {

	Button aplBtn;
	Button stbBtn;
	Button wmBtn;
	
	ImageView imgLayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		imgLayer = (ImageView) findViewById(R.id.imgLayer);
		aplBtn = (Button) findViewById(R.id.aplBtn);
		aplBtn.setOnClickListener(showApple);
		stbBtn = (Button) findViewById(R.id.stbBtn);
		stbBtn.setOnClickListener(showStrawberry);
		wmBtn = (Button) findViewById(R.id.wmBtn);
		wmBtn.setOnClickListener(showWatermelon);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}

	OnClickListener showApple = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			imgLayer.setImageResource(R.drawable.apple);
		}
	};

	OnClickListener showStrawberry = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			imgLayer.setImageResource(R.drawable.strawberry);
		}
	};	

	OnClickListener showWatermelon = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			imgLayer.setImageResource(R.drawable.watermelon);
		}
	};	
}
