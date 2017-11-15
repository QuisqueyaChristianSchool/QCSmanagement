package com.qcs.tdugue.qcsmanagementapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by tdugue on 10/23/2017.
 */

public class DeviceInformation extends AppCompatActivity {
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_information);
        //saving device information
        Save = (Button) findViewById(R.id.btnSave);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Information Saved", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
