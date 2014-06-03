package com.example.wayfarer_uiversion2;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * class InitialInterface
 * Description: display the initial interface
 * @author Mu
 */

public class InitialInterface extends Activity
{
	
    private FragmentManager fragmentManager = null;
    private FragmentTransaction fragmentTransaction;

    private String[] mItineraries = {"Setting"};
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private LayoutInflater inflater;

    private boolean isClosedBottominfo = true;

    public final static String DRAWER_SETTING_TAG = "DRAWER_SETTING_TAG";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        InitialFrag newFragment = new InitialFrag();
        fragmentTransaction.add(R.id.toptoolbar, newFragment);
        System.out.println("InitialFrag");
        fragmentTransaction.commit();

        
        // initial config for left drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // use myadapter to fill the listview
        // MyAdapter mAdapter = new MyAdapter(this);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mItineraries));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
	}
	
    // replace frag when click search
	public void Searchloc(View target)
	{
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment newFragment = new SearchFrag();
        fragmentTransaction.replace(R.id.toptoolbar, newFragment);
        fragmentTransaction.addToBackStack(null); 
        fragmentTransaction.commit();
        System.out.println("SearchFrag");    
	}

    // do nothing when click connect button(right of the top)
	public void Connect(View target)
	{
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment newFragment = new ConnectingFrag();
        fragmentTransaction.replace(R.id.toptoolbar, newFragment);
        fragmentTransaction.addToBackStack(null); 
        fragmentTransaction.commit();
        System.out.println("ConnectingFrag");

        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                fragmentTransaction = fragmentManager.beginTransaction();
                Fragment newFragment = new TopmenuOnlineFrag();
                fragmentTransaction.replace(R.id.toptoolbar, newFragment);
                fragmentTransaction.commit();
                System.out.println("TopmenuOnlineFrag");
            }
        };

        timer.schedule(task, 1000*3);
	}
 
    public void CheckAddr(View target)
    {
    	// To close the keyboard automatically.
        AutoCompleteTextView inputLocation = (AutoCompleteTextView)findViewById(R.id.dest_addr);
    	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 
    	imm.hideSoftInputFromWindow(inputLocation.getWindowToken(), 0);
        
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomStartFrag();
        fragmentTransaction.add(R.id.bottomtoolbar, newFragment);
        fragmentTransaction.addToBackStack(null); 
        fragmentTransaction.commit();
        
        // Change background pic.
        RelativeLayout toChangeBackground = (RelativeLayout)findViewById(R.id.total);
        toChangeBackground.setBackgroundResource(R.drawable.googlemapwithicon);

        System.out.println("BottomStartFragfrombutton");
    }
    
    // TODO clear bottominfofrag when second click failed
    // why findFragmentById still not equal to null after destroy frag?
    public void BottomInfo(View target)
    {
        System.out.println("enter BottomInfo");
        fragmentTransaction = fragmentManager.beginTransaction();
        System.out.println(fragmentManager.findFragmentById(R.id.bottominfo));
        if(isClosedBottominfo)
        {
            Fragment newFragment = new BottomInfoFrag();
            fragmentTransaction.add(R.id.bottominfo, newFragment);
            fragmentTransaction.addToBackStack(null); 
            fragmentTransaction.commit();
            System.out.println("BottomInfoFrag create");

            isClosedBottominfo = false;
        }
        else
        {
        	Fragment rmfrag = fragmentManager.findFragmentById(R.id.bottominfo);
            fragmentTransaction.remove(rmfrag);            
            fragmentTransaction.addToBackStack(null); 
            fragmentTransaction.commit();
            System.out.println("BottomInfoFrag clear");

            isClosedBottominfo = true;
        }
        
    }  

    public void BottomCancel(View target)
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        
        if(fragmentManager.findFragmentById(R.id.bottominfo)==null)
        {
            System.out.println("rm fragtwo null");
            Fragment rmfragone = fragmentManager.findFragmentById(R.id.bottomtoolbar);
            fragmentTransaction.remove(rmfragone);
            //fragmentTransaction.addToBackStack(null); 
            fragmentTransaction.commit();
        }
        else
        {
            Fragment rmfragone = fragmentManager.findFragmentById(R.id.bottomtoolbar);
            fragmentTransaction.remove(rmfragone);
            Fragment rmfragtwo = fragmentManager.findFragmentById(R.id.bottominfo);
            fragmentTransaction.remove(rmfragtwo);
            fragmentTransaction.commit();
            System.out.println("rm bottominfo");
        }
        // Change background pic.
        RelativeLayout toChangeBackground = (RelativeLayout)findViewById(R.id.total);
        toChangeBackground.setBackgroundResource(R.drawable.googlemap);
        System.out.println("rm bottomtoolbar");

    }

    public void BottomPlay(View target)
    {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomPauseFrag();
        fragmentTransaction.replace(R.id.bottomtoolbar, newFragment);
        fragmentTransaction.addToBackStack(null); 
        fragmentTransaction.commit();
        System.out.println("BottomPauseFrag");
    }

    public void BottomPause(View target)
    {
    	fragmentTransaction = fragmentManager.beginTransaction();
        Fragment newFragment = new BottomStartFrag();
        fragmentTransaction.replace(R.id.bottomtoolbar, newFragment);
        fragmentTransaction.addToBackStack(null); 
        fragmentTransaction.commit();
        System.out.println("BottomStartFrag again");
    }
    
    // show settings by left drawer when click a bottom button
	public void ShowDrawer(View target)
	{
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.openDrawer(mDrawerList);
	}

    // drawer list click listener
    private class DrawerItemClickListener implements ListView.OnItemClickListener 
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
            System.out.println("drawer onitemclick");
        }
    }

    private void selectItem(int position) 
    {
     //   DrawerDialogShow();
        
        System.out.println("drawer selectItem");

        // It should be startActivityForResult. I'll improve later.
        Intent intent = new Intent(this, DrawerSetting.class);
        String courier = "drawer setting";
        intent.putExtra("listen", courier);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        /*
        switch(resultCode)
        {
            case RESULT_OK:
                Bundle b = data.getExtras();  
                String str=b.getString("listen");
                // do nothing
                break;
            default:
                break;
        }
        */
    }



    /*
    public void DrawerDialogShow()
    {
        System.out.println("DrawerDialogShow");
        DrawerDialogFragment pdf = DrawerDialogFragment.newInstance("settings");
        FragmentTransaction ft = getFragmentManager().beginTransaction(); 
        pdf.show(ft, DRAWER_SETTING_TAG); 
    }
    */
}