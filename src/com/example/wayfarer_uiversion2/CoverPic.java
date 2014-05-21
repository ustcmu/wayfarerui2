package com.example.wayfarer_uiversion2;

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

public class CoverPic extends Activity implements OnGestureListener
{
	private GestureDetector detector;
	
	private static final String TAG = "CoverPic";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.coverpic_main);

		detector = new GestureDetector(this, this);
	}

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

	//

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cover_pic, menu);
		return true;
	}

}