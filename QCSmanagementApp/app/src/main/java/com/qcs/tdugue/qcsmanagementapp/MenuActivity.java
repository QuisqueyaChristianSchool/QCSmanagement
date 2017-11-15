package com.qcs.tdugue.qcsmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by hphanor on 10/23/2017.
 */

public class MenuActivity extends AppCompatActivity {
    ListView lv;
    String items[]  = { "User/ Device Information", "Interventions"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv = (ListView) findViewById(R.id.lvMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick (AdapterView<?> parent, View view, int position, long id)
                {
                    if (position==0){
                        Intent myintent = new Intent(view.getContext(),DeviceOptions.class);
                        startActivityForResult(myintent,0);
                    }
                    if (position==1){
                        Intent myintent = new Intent(view.getContext(),Intervention.class);
                        startActivityForResult(myintent,1);
                    }

            }
        });
    }
}