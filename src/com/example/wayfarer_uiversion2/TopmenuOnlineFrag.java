package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: almost same as Initial Frag, refer on mock page 5
 * note that right button shows connected
 **/
public class TopmenuOnlineFrag extends Fragment
{
	public TopmenuOnlineFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.topmenu_online_fragment, container, false);
	}

	
}