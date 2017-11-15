package com.qcs.tdugue.qcsmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.backendless.Backendless;
/**
 * Created by hphanor on 11/14/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    public static final String AplicationID = "6F3C8813-A0FC-71E2-FFCA-B5D5CDC6E200";
    public static final String SecretKey = "9D7A1A98-8D7D-9B52-FF75-EEBBCFB18A00";

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
        setContentView(R.layout.activity_details);

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

        final String text = device.getDateinformation()+ " " +device.getBelongs()+ " " +device.getBuilding()+ " " +device.getDevicetype()+ " " +device.getDevicename()+ " " +device.getEmail1()+ " " +device.getFirstname() + " " + device.getIpwired()+ " " + device.getIpwireless() + " " + device.getLastname() + " " + device.getMacwired() + " " + device.getMacwireless() + " " + device.getPhone()+ " " + device.getRoom();
        Share = (Button) findViewById(R.id.btnShare);
        Share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        text + "" + "For more information contact QCS ITsupport");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }

}