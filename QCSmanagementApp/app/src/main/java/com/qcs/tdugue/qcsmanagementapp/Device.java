package com.qcs.tdugue.qcsmanagementapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by hphanor on 10/24/2017.
 */

public class Device {

    public String getTextRecette() {
        return textRecette;
    }

    public String getImageRecette() {
        return imageRecette;
    }

    String textRecette;
    String imageRecette;


    public Device(String textRecette, String imageRecette){
        try{
            this.textRecette = "Jolies bonbons";
            this.imageRecette= "";

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Device> fromArray(Array[] array)

    {
        ArrayList<Device> results = new ArrayList<>();

        for(int x=0; x < array.length; x++){
            try{
                results.add(new Device(textRecette,imageRecette));

            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return results;
    }

}
