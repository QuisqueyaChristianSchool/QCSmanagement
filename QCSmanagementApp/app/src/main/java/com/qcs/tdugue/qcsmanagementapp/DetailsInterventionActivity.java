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

public class DetailsInterventionActivity extends AppCompatActivity {

    TextView textdate;
    TextView textitem;
    TextView textproblem;
    TextView textstatus;
    TextView textinitial;
    Button Share;

    interventions intervention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsintervention);

        intervention = (interventions) getIntent().getSerializableExtra("interventions");
        //retrieve all fields and set their value
        textdate = ButterKnife.findById(this, R.id.tvdate);
        textdate.setText(intervention.getDate_information());

        textitem = ButterKnife.findById(this,R.id.tvitem);
        textitem.setText(intervention.getItem());

        textproblem = ButterKnife.findById(this,R.id.tvproblem);
        textproblem.setText(intervention.getProblem());

        textstatus = ButterKnife.findById(this,R.id.tvstatus);
        textstatus.setText(intervention.getStatus());

        textinitial = ButterKnife.findById(this,R.id.tvinitial);
        textinitial.setText(intervention.getInitial());
        final String text ="Date: "+ intervention.getDate_information()+ "\n " +"Item / Who: "+intervention.getItem()+ "\n "+"What / Problem: " + intervention.getProblem()+ "\n "+"Status: " +intervention.getStatus()
                + "\n " +"Initial: "+ intervention.getInitial();

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
