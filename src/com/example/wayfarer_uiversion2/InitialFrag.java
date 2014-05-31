package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: first top toolbar, refer on mock page2
 * note that the right button shows disconnected
 **/
public class InitialFrag extends Fragment
{
	public InitialFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.topmenu_fragment, container, false);
	}	
}