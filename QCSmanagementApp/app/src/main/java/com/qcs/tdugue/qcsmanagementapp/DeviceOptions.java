package com.qcs.tdugue.qcsmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by hphanor on 11/15/2017.
 */

public class DeviceOptions extends AppCompatActivity {

Button Adding;
Button View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        View = (Button) findViewById(R.id.btnView);
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open new activity using intent
                Intent intent = new Intent(DeviceOptions.this, DeviceActivity.class);
                startActivity(intent);

            }

        });

        Adding = (Button) findViewById(R.id.btnAdd);
        Adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open new activity using intent
                Intent intent = new Intent(DeviceOptions.this, DeviceInformation.class);
                startActivity(intent);

            }

        });
    }
}
