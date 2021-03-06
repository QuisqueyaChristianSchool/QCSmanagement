package com.qcs.tdugue.qcsmanagementapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tdugue on 10/24/2017.
 */

public class DeviceActivity extends AppCompatActivity {
    ProgressDialog progress;
    public static final String AplicationID = "6F3C8813-A0FC-71E2-FFCA-B5D5CDC6E200";
    public static final String SecretKey = "9D7A1A98-8D7D-9B52-FF75-EEBBCFB18A00";


    public ArrayList<devices> listDevice;
    public ListView lvdevice;
    public Listviewdevice adapterDevice;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_listview);

        Backendless.initApp(getApplicationContext(), AplicationID, SecretKey);
        lvdevice = (ListView) findViewById(R.id.lvdevice);
        listDevice = new ArrayList<>();
        adapterDevice = new Listviewdevice(this, listDevice);
        lvdevice.setAdapter(adapterDevice);
        IDataStore<Map> devicesStorage = Backendless.Data.of("devices");
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        setloading();
        devicesStorage.find(queryBuilder, new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {

                adapterDevice.addAll(devices.fromListMap(response));
                progress.dismiss();
                adapterDevice.notifyDataSetChanged();
                Log.d("DEBUG", lvdevice.toString());
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        lvdevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view is an instance of MovieView
                //Expose details of movie (ratings (out of 10), popularity, and synopsis
                //ratings using RatingBar
                devices device = listDevice.get(position);

                Intent intent = new Intent(DeviceActivity.this, DetailsDeviceActivity.class);
                intent.putExtra("devices", device);
                startActivity(intent);

            }
        });


    }




    private void fetchdevice(String query) {
        lvdevice = (ListView) findViewById(R.id.lvdevice);
        listDevice = new ArrayList<>();
        adapterDevice = new Listviewdevice(this, listDevice);
        lvdevice.setAdapter(adapterDevice);
        IDataStore<Map> devicesStorage = Backendless.Data.of( "devices" );
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause("firstname like'%"+query+"%'");
        devicesStorage.find(queryBuilder,new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {
                adapterDevice.addAll(devices.fromListMap(response));
                adapterDevice.notifyDataSetChanged();
                Log.d("DEBUG",lvdevice.toString());
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void setloading(){
        progress = new ProgressDialog(this);
        progress.setMessage("Loading all device information...");
        progress.setCancelable(false);
        progress.show();
    }
}
