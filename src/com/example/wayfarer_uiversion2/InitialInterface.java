package com.example.wayfarer_uiversion2;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
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

public class InitialInterface extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//getSupportFragmentManager().beginTransaction().add(R.id.topmenu_frag, ((InitialFrag) new InitialFrag())).commit();
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fT = fragmentManager.beginTransaction();
		fT.add(R.id.topmenu_frag, new InitialFrag());
		fT.commit();
		System.out.println("interface1");
	}
	
	public void Searchloc(View target)
	{
		System.out.println("interface2");
		getSupportFragmentManager().beginTransaction().replace(R.id.topsearch_frag, ((SearchFrag)new SearchFrag())).commit();	
	}

	public void Confirm(View target)
	{
	}
}