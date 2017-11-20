package com.qcs.tdugue.qcsmanagementapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tdugue on 11/20/2017.
 */

public class Listviewintervention extends ArrayAdapter<interventions> {
    private static class ViewHolder {
        TextView textdate;
        TextView textitem;
        TextView textproblem;
        TextView textstatus;
        TextView textinitial;

    }
    public Listviewintervention(Context context, ArrayList<interventions> interventioninfo) {
        super(context, R.layout.intervention_layout, interventioninfo);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        interventions r = getItem(position);
        Listviewintervention.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new Listviewintervention.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.intervention_layout, parent, false);

            viewHolder.textdate = (TextView) convertView.findViewById(R.id.tvdate);
            viewHolder.textitem = (TextView) convertView.findViewById(R.id.tvbelong);
            viewHolder.textinitial = (TextView) convertView.findViewById(R.id.tvbuilding);
            viewHolder.textproblem = (TextView) convertView.findViewById(R.id.tvdevicetype);
            viewHolder.textstatus = (TextView) convertView.findViewById(R.id.tvdevicename);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Listviewintervention.ViewHolder) convertView.getTag();
        }
        viewHolder.textdate.setText(r.getDate_information());
        viewHolder.textitem.setText(r.getItem());
        viewHolder.textproblem.setText(r.getProblem());
        viewHolder.textinitial.setText(r.getInitial());
        viewHolder.textstatus.setText(r.getStatus());
        return convertView;
    }
}

