package com.qcs.tdugue.qcsmanagementapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tdugue on 10/23/2017.
 */


public class interventions implements Serializable {

    private String date_information;
    private String item;
    private String initial;
    private String problem;
    private String status;

    public String getDate_information() {
        return date_information;
    }
    public void setDate_information(String date_information) {this.date_information = date_information;}
    public String getItem() {
        return item;
    }
    public void setItem(String item) {this.item = item;}
    public String getInitial() {
        return initial;
    }
    public void setInitial(String initial) {this.initial = initial;}
    public String getProblem() {
        return problem;
    }
    public void setProblem(String problem ) {this.problem = problem;}
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {this.status = status;}

    public static ArrayList<interventions> fromListMap(List<Map> map) {
        ArrayList<interventions> intervention = new ArrayList();
        for(int i = 0; i < map.size(); i++) {
            interventions info1 = new interventions();
            info1.setDate_information((String) map.get(i).get("dateinformation"));
            info1.setItem((String) map.get(i).get("item"));
            info1.setInitial((String) map.get(i).get("initial"));
            info1.setProblem((String) map.get(i).get("problem"));
            info1.setStatus((String) map.get(i).get("status"));

            intervention.add(info1);
        }

        return intervention;
    }


}


