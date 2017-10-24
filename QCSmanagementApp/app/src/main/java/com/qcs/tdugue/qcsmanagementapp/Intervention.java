package com.qcs.tdugue.qcsmanagementapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by hphanor on 10/23/2017.
 */

public class Intervention extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervention);

        Toast.makeText(Intervention.this, "INTERVENTION", Toast.LENGTH_LONG).show();
    }
}
