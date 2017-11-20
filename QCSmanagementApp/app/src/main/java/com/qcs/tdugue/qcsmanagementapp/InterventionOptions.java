package com.qcs.tdugue.qcsmanagementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tdugue on 11/20/2017.
 */

public class InterventionOptions extends AppCompatActivity {

    Button Adding1;
    Button View1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options1);

        View1 = (Button) findViewById(R.id.btnView1);
        View1.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open new activity using intent
                Intent intent = new Intent(InterventionOptions.this, InterventionActivity.class);
                startActivity(intent);

            }

        });

        Adding1= (Button) findViewById(R.id.btnAdd1);
        Adding1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open new activity using intent
                Intent intent = new Intent(InterventionOptions.this, InterventionInformation.class);
                startActivity(intent);

            }

        });
    }
}
