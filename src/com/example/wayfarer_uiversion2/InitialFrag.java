package com.example.wayfarer_uiversion2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InitialFrag extends Fragment
{
	private static String TAG = "InitialFrag";
	
	public InitialFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.topmenu_fragment, container, false);
	}
}