package com.example.wayfarer_uiversion2;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * class InitialInterface
 * Description: display the initial interface
 * @author Mu
 */

public class InitialInterface extends Activity
{
	
    private FragmentManager fragmentManager = null;

    private String[] mItineraries = {"Beijing", "SValley"};
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        InitialFrag newFragment = new InitialFrag();
        ft.add(R.id.toptoolbar, newFragment);
        ft.commit();
	
        // initial config for left drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mItineraries));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		
        
        // use actionbar to control drawer list
		mDrawerToggle = new ActionBarDrawerToggle(
                this,                 
                mDrawerLayout,         
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close) 
           {
            	
            	public void onDrawerClosed(View view) {
            	    super.onDrawerClosed(view);
            	}
     			
     			public void onDrawerOpened(View drawerView) {
     	    		super.onDrawerOpened(drawerView);
        		}
        	};
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
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

	public void ShowAllItineraries(View target)
	{
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
	@Override  
	protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    	super.onConfigurationChanged(newConfig);
	        // Pass any configuration change to the drawer toggls
	        mDrawerToggle.onConfigurationChanged(newConfig);
	}
	/* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener 
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) 
    {
        // update main content in map
        // TODO
    }
    
   
}