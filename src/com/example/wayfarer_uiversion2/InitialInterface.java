package com.example.wayfarer_uiversion2;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
    private FragmentTransaction ft;

    private String[] mItineraries = {"Beijing", "SValley"};
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private LayoutInflater inflater;

    private boolean is_closed_bottominfo = true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		fragmentManager = getFragmentManager();
        ft = fragmentManager.beginTransaction();
        InitialFrag newFragment = new InitialFrag();
        ft.add(R.id.toptoolbar, newFragment);
        System.out.println("InitialFrag");
        ft.commit();

        
        // initial config for left drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // use myadapter to fill the listview
        // MyAdapter mAdapter = new MyAdapter(this);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mItineraries));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        

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
        ft = fragmentManager.beginTransaction();
        Fragment newFragment = new SearchFrag();
        ft.replace(R.id.toptoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("SearchFrag");    
	}

    // do nothing when click connect button(right of the top)
	public void Connect(View target)
	{
        ft = fragmentManager.beginTransaction();
        Fragment newFragment = new ConnectingFrag();
        ft.replace(R.id.toptoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("ConnectingFrag");

        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                ft = fragmentManager.beginTransaction();
                Fragment newFragment = new TopmenuOnlineFrag();
                ft.replace(R.id.toptoolbar, newFragment);
                ft.commit();
                System.out.println("TopmenuOnlineFrag");
            }
        };

        timer.schedule(task, 1000*3);
	}
 
    public void CheckAddr(View target)
    {
        ft = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomStartFrag();
        ft.add(R.id.bottomtoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("BottomStartFragfrombutton");
    }
    
    // TODO clear bottominfofrag when second click failed
    // why findFragmentById still not equal to null after destroy frag?
    public void BottomInfo(View target)
    {
        System.out.println("enter BottomInfo");
        ft = fragmentManager.beginTransaction();
        System.out.println(fragmentManager.findFragmentById(R.id.bottominfo));
        if(is_closed_bottominfo)
        {
            Fragment newFragment = new BottomInfoFrag();
            ft.add(R.id.bottominfo, newFragment);
            ft.addToBackStack(null); 
            ft.commit();
            System.out.println("BottomInfoFrag create");

            is_closed_bottominfo = false;
        }
        else
        {
        	Fragment rmfrag = fragmentManager.findFragmentById(R.id.bottominfo);
            ft.remove(rmfrag);            
            ft.addToBackStack(null); 
            ft.commit();
            System.out.println("BottomInfoFrag clear");

            is_closed_bottominfo = true;
        }
        
    }  

    public void BottomCancel(View target)
    {
        ft = fragmentManager.beginTransaction();
        Fragment rmfragone = fragmentManager.findFragmentById(R.id.bottomtoolbar);
        ft.remove(rmfragone);
        ft.addToBackStack(null); 
        System.out.println("rm bottomtoolbar");

        Fragment rmfragtwo = fragmentManager.findFragmentById(R.id.bottominfo);
        ft.remove(rmfragtwo);
        ft.commit();
        System.out.println("rm bottominfo");
    }

    public void BottomPlay(View target)
    {
        ft = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomPauseFrag();
        ft.replace(R.id.bottomtoolbar, newFragment);
        ft.addToBackStack(null); 
        ft.commit();
        System.out.println("BottomPauseFrag");
    }

    public void BottomPause(View target)
    {
    	ft = fragmentManager.beginTransaction();
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
}