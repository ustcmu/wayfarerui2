package com.example.wayfarer_uiversion2;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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
    private ImageButton ib;
    private ActionBarDrawerToggle mDrawerToggle;
    private LayoutInflater inflater;

    private ImageView iv;

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

        /*
        inflater = getLayoutInflater();
		View v1 = inflater.inflate(R.layout.topsearch_fragment, null);
        iv = (ImageView)v1.findViewById(R.id.check_img);
        System.out.println("got the imageview");
        iv.setOnClickListener(new View.OnClickListener()
        {        	
        	
            @Override
            public void onClick(View v)
            {	
            	System.out.println("on click");
            	Toast.makeText(InitialInterface.this, "click the image view", Toast.LENGTH_LONG).show();
            }
        });
        */
	}

    // do nothing when click connect button(right of the top)
	public void Connect(View target)
	{
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new ConnectingFrag();
        ft.replace(R.id.toptoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("ConnectingFrag");
	}
 
    public void CheckAddr(View target)
    {
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomStartFrag();
        ft.add(R.id.bottomtoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("BottomStartFragfrombutton");
    }
    
    public void BottomInfo(View target)
    {
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if(fragmentManager.findFragmentById(R.id.bottominfo) == null)
        {
            Fragment newFragment = new BottomInfoFrag();
            ft.add(R.id.bottominfo, newFragment);
            ft.addToBackStack(null); 
            ft.commit();
            System.out.println("BottomInfoFrag create");
        }
        else
        {
            Fragment rmfrag = fragmentManager.findFragmentById(R.id.bottominfo);
            ft.remove(rmfrag);
        }
        
    }  

    public void BottomCancel(View target)
    {
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment rmfragone = fragmentManager.findFragmentById(R.id.bottomtoolbar);
        ft.remove(rmfragone);
        System.out.println("rm bottomtoobar");
        ft.commit();
        
        Fragment rmfragtwo = fragmentManager.findFragmentById(R.id.bottominfo);
        ft.remove(rmfragtwo);
        System.out.println("rm bottominfo");
        
        if(fragmentManager.findFragmentById(R.id.bottominfo) == null)
        	System.out.println("rm succeed");
      /*
        if(fragmentManager.findFragmentById(R.id.bottominfo) != null)
        {
        	System.out.println("enter loop");
            Fragment fragtwo = fragmentManager.findFragmentById(R.id.bottominfo);
            ft.remove(fragtwo);
            System.out.println("rm bottominfo");
            ft.commit();
        }
        */
    }

    public void BottomPlay(View target)
    {
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomPauseFrag();
        ft.replace(R.id.bottomtoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("BottomPauseFrag");
    }

    public void BottomPause(View target)
    {
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomStartFrag();
        ft.replace(R.id.bottomtoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("BottomStartFrag again");
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
    
}