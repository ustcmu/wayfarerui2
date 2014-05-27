package com.example.wayfarer_uiversion2;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Build;
import android.os.Bundle;
import android.os.IInterface;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;


/**
 * class CoverPic
 * @author Mu
 * description: provide cover picture for app
 **/

public class CoverPic extends Activity
{
	//	private GestureDetector detector;
	
	private static final String TAG = "CoverPic";

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
	//	detector = new GestureDetector(this, this);
	}

	// throw following codes away
	// because we hope loading pic will disappear automatically
	// but not by touch
	/*
	// different Gesture action
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		return this.detector.onTouchEvent(event);
		
	}

	@Override
	public boolean onDown(MotionEvent e)
	{
		Log.v(TAG, "onDown: " + e.getAction());
		Intent intent = new Intent(this, InitialInterface.class);
		startActivity(intent);
		return true;
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
	{
		return false;
	}
	@Override
	public void onLongPress(MotionEvent e)
	{}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
	{
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e)
	{
		Log.i(TAG, "onShowPress: " + e.getAction());  
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e)
	{
		Log.i(TAG, "onSingleTapUp: " + e.getAction());
		return true;
	}
	*/
	
	// creat menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cover_pic, menu);
		return true;
	}

}