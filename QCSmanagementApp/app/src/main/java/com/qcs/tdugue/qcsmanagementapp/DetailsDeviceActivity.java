package com.qcs.tdugue.qcsmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;

/**
 * Created by tdugue on 11/14/2017.
 */

public class DetailsDeviceActivity extends AppCompatActivity {

    TextView textdate;
    TextView textbuilding;
    TextView textroom;
    TextView textfirstname;
    TextView textlastname;
    TextView textphone;
    TextView textemail;
    TextView textdevicetype;
    TextView textbelongs;
    TextView textdevicename;
    TextView textmacwireless;
    TextView textipwireless;
    TextView textmacwired;
    TextView textipwired;
    Button Share;

    devices device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsdevice);

        device = (devices) getIntent().getSerializableExtra("devices");

        //retrieve all fields and set their value

        textdate = ButterKnife.findById(this, R.id.tvdate);
        textdate.setText(device.getDateinformation());

        textbelongs = ButterKnife.findById(this,R.id.tvbelong);
        textbelongs.setText(device.getBelongs());

        textbuilding = ButterKnife.findById(this,R.id.tvbuilding);
        textbuilding.setText(device.getBuilding());

        textdevicetype = ButterKnife.findById(this,R.id.tvdevicetype);
        textdevicetype.setText(device.getDevicetype());

        textdevicename = ButterKnife.findById(this,R.id.tvdevicename);
        textdevicename.setText(device.getDevicename());

        textemail = ButterKnife.findById(this,R.id.tvemail);
        textemail.setText(device.getEmail1());

        textfirstname = ButterKnife.findById(this,R.id.tvfirstname);
        textfirstname.setText(device.getFirstname());

        textipwired = ButterKnife.findById(this,R.id.tvwiredip);
        textipwired.setText(device.getIpwired());

        textipwireless = ButterKnife.findById(this,R.id.tvwirelessip);
        textipwireless.setText(device.getIpwireless());

        textlastname = ButterKnife.findById(this,R.id.tvlastname);
        textlastname.setText(device.getLastname());

        textmacwired = ButterKnife.findById(this,R.id.tvwiredmac);
        textmacwired.setText(device.getMacwired());

        textmacwireless = ButterKnife.findById(this,R.id.tvwirelessmac);
        textmacwireless.setText(device.getMacwireless());

        textphone = ButterKnife.findById(this,R.id.tvphone);
        textphone.setText(device.getPhone());

        textroom = ButterKnife.findById(this,R.id.tvroom);
        textroom.setText(device.getRoom());

        final String text ="Date: "+ device.getDateinformation()+ "\n " +"Building name: "+device.getBuilding()+ "\n "+"Room: " + device.getRoom()+ "\n "+"Firstname: " +device.getFirstname()
                + "\n " +"Lastname: "+ device.getLastname()+ "\n "+"Phone: " + device.getPhone()+ "\n"+"Email: " +device.getEmail1()+ "\n " +"Device Name: "+device.getDevicename()+"\n"+ "Belongs to: "+device.getBelongs()+ "\n " +"Device Type: "+device.getDevicetype()
                + "\n " +"Physical address(Wireless): "+ device.getMacwireless()+ "\n "+"Assigned IP: " + device.getIpwireless()+ "\n "+"Physical address(Wired): " + device.getMacwired() + "\n " +"Assigned IP: "+ device.getIpwired() ;

        Share = (Button) findViewById(R.id.btnShare);
        Share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }

}