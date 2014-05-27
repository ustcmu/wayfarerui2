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
import android.widget.ImageButton;
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
    private ImageButton bButton;
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
        System.out.println("InitialFrag");
        ft.commit();

        /*
        // initial config for left drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // use myadapter to fill the listview
        // MyAdapter mAdapter = new MyAdapter(this);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mItineraries));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        */

        /*
        // use actionbar to control drawer list
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

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
        */
	}
	
    // replace frag when click search
	public void Searchloc(View target)
	{
		fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new SearchFrag();
        ft.replace(R.id.toptoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("SearchFrag");

	}

    // do nothing when click confirm
	public void Confirm(View target)
	{
	}

    /*
    // show itineraries by left drawer when click a bottom button
	public void ShowAllItineraries(View target)
	{
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.openDrawer(mDrawerList);
	}
	*/

    /*
    // enable drawer list by top actionbar
	public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

    // write for top actionbar/ toggle
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
    */
    
    /*
    // drawer list click listener
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
    */
    
    public void CheckAddr(View target)
    {
    	fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomStartFrag();
        ft.add(R.id.bottomtoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("BottomStartFrag");
    }
	
}