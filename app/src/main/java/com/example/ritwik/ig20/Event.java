package com.example.ritwik.ig20;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.List;

public class Event implements Serializable {
    String eventName;
    String desc;
    String Image;
    String rules;
    int csePts;
    int ecePts;
    int mmePts;
    int civPts;
    int metaPts;
    int chemPts;
    int eeePts;
    int archiPts;
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    //    int fixtures;



    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Event(String eventName, String desc , String Image) {
        this.eventName = eventName;
        this.desc = desc;
        this.Image = Image;
    }
}
