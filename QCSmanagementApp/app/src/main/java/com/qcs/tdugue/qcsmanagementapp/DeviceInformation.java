package com.qcs.tdugue.qcsmanagementapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.qcs.tdugue.qcsmanagementapp.Account.LoadingCallback;

/**
 * Created by hphanor on 10/23/2017.
 */

public class DeviceInformation extends AppCompatActivity {
    Button View;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_information);
        View = (Button) findViewById(R.id.btnView);
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open new activity using intent
                Intent intent = new Intent(DeviceInformation.this, DeviceActivity.class);
                startActivity(intent);

            }

        });
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
