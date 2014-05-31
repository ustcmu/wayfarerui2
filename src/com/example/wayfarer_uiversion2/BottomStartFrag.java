package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: shows bottombar, for control(start navi), refer on mock 9
 **/
public class BottomStartFrag extends Fragment
{
	public BottomStartFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.bottomstart_fragment, container, false);
	}

	
}