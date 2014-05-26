package com.example.wayfarer_uiversion2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

/**
 * class InitialInterface
 * Description: display the initial interface
 * @author Mu
 */

public class InitialInterface extends Activity
{
	
    private FragmentManager fragmentManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        InitialFrag newFragment = new InitialFrag();
        ft.add(R.id., newFragment);
        ft.commit();
	}
	
	public void Searchloc(View target)
	{
		fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new SearchFrag();
        ft.replace(R.id.toptoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();	
	}

	public void Confirm(View target)
	{
	}
}