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

        //Using a custom toolbar instead of having the same title on each page
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.actionbar_device_information);

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
        Backendless.initApp(this, BackendSettings.AplicationID, BackendSettings.SecretKey);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        View.OnClickListener btnSaveClickListener = createbtnSaveClickListener();
        btnSave.setOnClickListener(btnSaveClickListener);
    }


    public View.OnClickListener createbtnSaveClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etDate = (EditText) findViewById( R.id.etDate );
                EditText etBuilding = (EditText) findViewById( R.id.etBuilding );
                EditText etRoom = (EditText) findViewById( R.id.etRoom );
                EditText etFirstname = (EditText) findViewById( R.id.etFirstname );
                EditText etLastname = (EditText) findViewById( R.id.etLastname );
                EditText etPhone = (EditText) findViewById( R.id.etPhone );
                EditText etEmail = (EditText) findViewById( R.id.etEmail );
                EditText etHostname = (EditText) findViewById( R.id.etHostname );
                EditText etWirelessMAC = (EditText) findViewById( R.id.etWirelessMAC );
                EditText etWirelessIP = (EditText) findViewById( R.id.etWirelessIP );
                EditText etWiredMAC = (EditText) findViewById( R.id.etWiredMAC );
                EditText etWiredIP = (EditText) findViewById( R.id.etWiredIP );

                CharSequence dateinformation = etDate.getText();
                CharSequence building = etBuilding.getText();
                CharSequence room = etRoom.getText();
                CharSequence firstname = etFirstname.getText();
                CharSequence lastname = etLastname.getText();
                CharSequence phone = etPhone.getText();
                CharSequence email = etEmail.getText();
                CharSequence devicename = etHostname.getText();
                CharSequence macwireless = etWirelessMAC.getText();
                CharSequence ipwireless = etWirelessIP.getText();
                CharSequence macwired = etWiredMAC.getText();
                CharSequence ipwired = etWiredIP.getText();

            }

        };

    }
}