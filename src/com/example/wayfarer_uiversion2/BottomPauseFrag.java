package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: shows bottombar, for control(pause navi), refer on mock 10
 **/
public class BottomPauseFrag extends Fragment
{
	public BottomPauseFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.bottompause_fragment, container, false);
	}

	
}