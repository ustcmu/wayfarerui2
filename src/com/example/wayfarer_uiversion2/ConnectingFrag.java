package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: after click right connect button, show app's connecting w.d.
 * refer on mock page 4
 **/
public class ConnectingFrag extends Fragment
{
	public ConnectingFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.top_connecting_fragment, container, false);
	}

	
}