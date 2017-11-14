package com.qcs.tdugue.qcsmanagementapp;
import android.content.Intent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tdugue on 10/24/2017.
 */

public class Listviewdevice extends ArrayAdapter<devices> {
    private static class ViewHolder {
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
    }
    public Listviewdevice(Context context, ArrayList<devices> deviceinfo) {
        super(context, R.layout.device_layout, deviceinfo);

    }
    Button Share;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        devices r = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.device_layout, parent, false);

            viewHolder.textdate = (TextView) convertView.findViewById(R.id.tvdate);
            viewHolder.textbelongs = (TextView) convertView.findViewById(R.id.tvbelong);
            viewHolder.textbuilding = (TextView) convertView.findViewById(R.id.tvbuilding);
            viewHolder.textdevicetype = (TextView) convertView.findViewById(R.id.tvdevicetype);
            viewHolder.textdevicename = (TextView) convertView.findViewById(R.id.tvdevicename);
            viewHolder.textemail = (TextView) convertView.findViewById(R.id.tvemail);
            viewHolder.textfirstname = (TextView) convertView.findViewById(R.id.tvfirstname);
            viewHolder.textipwired = (TextView) convertView.findViewById(R.id.tvwiredip);
            viewHolder.textipwireless = (TextView) convertView.findViewById(R.id.tvwirelessip);
            viewHolder.textlastname = (TextView) convertView.findViewById(R.id.tvlastname);
            viewHolder.textmacwired = (TextView) convertView.findViewById(R.id.tvwiredmac);
            viewHolder.textmacwireless = (TextView) convertView.findViewById(R.id.tvwirelessmac);
            viewHolder.textphone = (TextView) convertView.findViewById(R.id.tvphone);
            viewHolder.textroom = (TextView) convertView.findViewById(R.id.tvroom);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textdate.setText(r.getDateinformation());
        viewHolder.textbelongs.setText(r.getBelongs());
        viewHolder.textbuilding.setText(r.getBuilding());
        viewHolder.textdevicetype.setText(r.getDevicetype());
        viewHolder.textdevicename.setText(r.getDevicename());
        viewHolder.textemail.setText(r.getEmail1());
        viewHolder.textfirstname.setText(r.getFirstname());
        viewHolder.textipwired.setText(r.getIpwired());
        viewHolder.textipwireless.setText(r.getIpwireless());
        viewHolder.textlastname.setText(r.getLastname());
        viewHolder.textmacwired.setText(r.getMacwired());
        viewHolder.textmacwireless.setText(r.getMacwireless());
        viewHolder.textphone.setText(r.getPhone());
        viewHolder.textroom.setText(r.getRoom());
        return convertView;
    }
}
