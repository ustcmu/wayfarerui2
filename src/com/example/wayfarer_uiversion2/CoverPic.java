package com.example.wayfarer_uiversion2;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

/**
 * class CoverPic
 * @author Mu
 * Description: provide cover picture for app
 **/

public class CoverPic extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coverpic_main);

		final Intent intent = new Intent(this, InitialInterface.class);

		Timer timer = new Timer();
		TimerTask task = new TimerTask()
		{
			@Override
			public void run()
			{
				startActivity(intent);
				CoverPic.this.finish();
			}
		};

		timer.schedule(task, 1000*3);
	}
}