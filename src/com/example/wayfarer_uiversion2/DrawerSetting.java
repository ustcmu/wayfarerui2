package com.example.wayfarer_uiversion2;


import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class DrawerSetting extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer_setting_act);
		System.out.println("DrawerSetting Activity created");
	}

	public void CheckSetting(View target)
	{
		Intent intent = new Intent(this, InitialInterface.class);
		setResult(RESULT_OK, intent); 
		// Do nothing.
		finish();
	}
	
}