package com.qcs.tdugue.qcsmanagementapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hphanor on 10/24/2017.
 */

public class devices implements Serializable{

    private String dateinformation;
    private String belongs;
    private String building;
    private String devicetype ;
    private String email;
    private String firstname;
    private String devicename;
    private String ipwired;
    private String ipwireless;
    private String lastname;
    private String macwired;
    private String macwireless;
    private String phone;
    private String room;

    public String getDateinformation() {
        return dateinformation;
    }
    public void setDateinformation(String dateinformation) {this.dateinformation = dateinformation;}

    public String getBelongs() {
        return belongs;
    }
    public void setBelongs(String belongs) {this.belongs = belongs;}

    public String getBuilding() {
        return building;
    }
    public void setBuilding(String building) {this.building = building;}

    public String getDevicetype() {
        return devicetype;
    }
    public void setDevicetype(String devicetype ) {this.devicetype = devicetype;}

    public String getEmail1() {
        return email;
    }
    public void setEmail1(String email) {this.email = email;}

    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) {this.firstname = firstname;}

    public String getDevicename() {
        return devicename;
    }
    public void setDevicename(String devicename) {this.devicename = devicename;}

    public String getIpwired() {
        return ipwired;
    }
    public void setIpwired(String ipwired) {this.ipwired = ipwired;}

    public String getIpwireless() {
        return ipwireless;
    }
    public void setIpwireless(String ipwireless) {this.ipwireless = ipwireless;}

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getMacwired() {
        return macwired;
    }
    public void setMacwired(String macwired) {this.macwired = macwired;}

    public String getMacwireless() {return macwireless;}
    public void setMacwireless(String macwireless) {this.macwireless = macwireless;}

    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {this.room = room;}

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {this.phone = phone;}


    public static ArrayList<devices> fromListMap(List<Map> map) {

        ArrayList<devices> device = new ArrayList();

        for(int i = 0; i < map.size(); i++) {
            devices info = new devices();
            info.setDateinformation((String) map.get(i).get("dateinformation"));
            info.setBelongs((String) map.get(i).get("belongs"));
            info.setBuilding((String) map.get(i).get("building"));
            info.setDevicetype((String) map.get(i).get("devicetype"));
            info.setEmail1((String) map.get(i).get("email"));
            info.setFirstname((String) map.get(i).get("firstname"));
            info.setDevicename((String) map.get(i).get("devicename"));
            info.setIpwired((String) map.get(i).get("ipwired"));
            info.setIpwireless((String) map.get(i).get("ipwireless"));
            info.setLastname((String) map.get(i).get("lastname"));
            info.setMacwired((String) map.get(i).get("macwired"));
            info.setMacwireless((String) map.get(i).get("macwireless"));
            info.setRoom((String) map.get(i).get("room"));
            info.setPhone((String) map.get(i).get("phone"));

            device.add(info);
        }

        return device;
    }


    }


