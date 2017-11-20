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

public class InterventionActivity extends AppCompatActivity {
    ProgressDialog progress;
    public static final String AplicationID = "6F3C8813-A0FC-71E2-FFCA-B5D5CDC6E200";
    public static final String SecretKey = "9D7A1A98-8D7D-9B52-FF75-EEBBCFB18A00";


    public ArrayList<interventions> listIntervention;
    public ListView lvintervention;
    public Listviewintervention adapterIntervention;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intervention_listview);

        Backendless.initApp(getApplicationContext(), AplicationID, SecretKey);
        lvintervention = (ListView) findViewById(R.id.lvintervention);
        listIntervention = new ArrayList<>();
        adapterIntervention = new Listviewintervention(this, listIntervention);
        lvintervention.setAdapter(adapterIntervention);
        IDataStore<Map> interventionsStorage = Backendless.Data.of("interventions");
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        setloading();
        interventionsStorage.find(queryBuilder, new AsyncCallback<List<Map>>()
        {
            @Override
            public void handleResponse(List<Map> response) {
                adapterIntervention.addAll(interventions.fromListMap(response));
                progress.dismiss();
                adapterIntervention.notifyDataSetChanged();
                Log.d("DEBUG", lvintervention.toString());
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(getApplicationContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        lvintervention.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                interventions intervention = listIntervention.get(position);
                Intent intent = new Intent(InterventionActivity.this, DetailsInterventionActivity.class);
                intent.putExtra("interventions", intervention);
                startActivity(intent);
            }
        });
    }

    private void fetchdevice(String query) {
        lvintervention = (ListView) findViewById(R.id.lvintervention);
        listIntervention = new ArrayList<>();
        adapterIntervention = new Listviewintervention(this, listIntervention);
        lvintervention.setAdapter(adapterIntervention);
        IDataStore<Map> interventionsStorage = Backendless.Data.of( "interventions" );
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause("firstname like'%"+query+"%'");
        interventionsStorage.find(queryBuilder,new AsyncCallback<List<Map>>()

        {
            @Override
            public void handleResponse(List<Map> response) {
                adapterIntervention.addAll(interventions.fromListMap(response));
                adapterIntervention.notifyDataSetChanged();
                Log.d("DEBUG",lvintervention.toString());
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
        progress.setMessage("Loading all interventions ...");
        progress.setCancelable(false);
        progress.show();
    }
}
