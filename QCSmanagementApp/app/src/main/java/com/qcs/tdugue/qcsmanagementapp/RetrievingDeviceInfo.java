package com.qcs.tdugue.qcsmanagementapp;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hphanor on 10/23/2017.
 */

public class RetrievingDeviceInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieving_device_information);

        //Using a custom toolbar instead of having the same title on each page
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_retrievingdeviceinformation);

    }
}
