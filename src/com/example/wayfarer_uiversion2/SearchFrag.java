package com.example.wayfarer_uiversion2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description: top toolbar, user input location in searchbar here, refer on mock page 6
 * Question: how to synchronize the right connect button?
 **/
public class SearchFrag extends Fragment
{
	public SearchFrag(){}
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.topsearch_fragment, container, false);
	}
}