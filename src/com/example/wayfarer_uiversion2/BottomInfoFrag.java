package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: at bottom, show info(waypoints and distance) , refer on mock 11
 **/
public class BottomInfoFrag extends Fragment
{
	public BottomInfoFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.bottominfo_fragment, container, false);
	}	
}