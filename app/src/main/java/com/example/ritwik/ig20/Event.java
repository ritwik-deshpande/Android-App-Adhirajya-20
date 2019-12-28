package com.example.ritwik.ig20;

import java.io.Serializable;
import java.util.Dictionary;

public class Event implements Serializable {
    String eventName;
    String desc;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    //    int fixtures;
    String Image;


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

//    public Dictionary getPoints() {
//        return points;
//    }
//
//    public void setPoints(Dictionary points) {
//        this.points = points;
//    }

    public Event(String eventName, String desc ,String Image) {
        this.eventName = eventName;
        this.desc = desc;
        this.Image = Image;

    }
}
