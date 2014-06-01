package com.example.wayfarer_uiversion2;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DrawerDialogFragment extends DialogFragment
{
	public static DrawerDialogFragment newInstance(String setting){ 
        DrawerDialogFragment pdf = new DrawerDialogFragment(); 
        Bundle b = new Bundle(); 
        b.putString("setting-message", setting); 
        pdf.setArguments(b); 
        return pdf; 
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.drawer_setting, container, false);
	}

	// SettingDone is the button on dialogfragment for confirm.
    public void SettingDone()
    {
        System.out.println("drawer settings done");
        dismiss();
    // You should get the address from EditText.
    // Then connect to BLE.        
    }
}