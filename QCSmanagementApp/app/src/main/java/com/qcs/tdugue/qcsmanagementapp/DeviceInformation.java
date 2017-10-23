package com.qcs.tdugue.qcsmanagementapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hphanor on 10/23/2017.
 */

public class DeviceInformation extends AppCompatActivity {

    Button Save; Button Show;
    EditText Firstname; EditText Lastname;
    EditText Email; EditText Phone;
    EditText Hostname; EditText WirelessMAC;
    EditText WirelessIP; EditText WiredMAC;
    EditText WiredIP; EditText Date;
    EditText Building; EditText Room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_information);

        //Using a custom toolbar instead of having the same title on each page
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_device_information);

        Save = (Button) findViewById(R.id.btnSave); Show = (Button) findViewById(R.id.btnShow);
        Firstname = (EditText) findViewById(R.id.etFirstname); Lastname = (EditText) findViewById(R.id.etLastname);
        Email = (EditText) findViewById(R.id.etEmail); Phone = (EditText) findViewById(R.id.etPhone);
        Hostname = (EditText) findViewById(R.id.etHostname); WirelessMAC = (EditText) findViewById(R.id.etWirelessMAC);
        WirelessIP = (EditText) findViewById(R.id.etWirelessIP); WiredMAC = (EditText) findViewById(R.id.etWiredMAC);
        WiredIP = (EditText) findViewById(R.id.etWiredIP); Date = (EditText) findViewById(R.id.etDate);
        Building = (EditText) findViewById(R.id.etBuilding); Room = (EditText) findViewById(R.id.etBuilding);
        Show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Open new activity using intent
                Intent intent = new Intent(DeviceInformation.this, RetrievingDeviceInfo.class);
                startActivity(intent);

                //Saving the information from all edittext
                //String str = Firstname.getText().toString();

            }

        });

        Save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Show successful test
                Toast.makeText(DeviceInformation.this, "Information Saved", Toast.LENGTH_LONG).show();

            }

        });
    }
}
