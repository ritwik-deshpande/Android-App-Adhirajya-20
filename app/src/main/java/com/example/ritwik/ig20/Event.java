package com.example.ritwik.ig20;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.List;

public class Event implements Serializable {
    String eventName;
    String desc;
    String Image;
    String venue;
    int csePts;
    int ecePts;
    int mechPts;
    int civPts;
    int metaPts;
    int chemPts;
    int eeePts;
    int archiPts;

    public Event(){

    }

    public Event(String eventName, String desc, String image, String venue, int csePts, int ecePts, int mechPts, int civPts, int metaPts, int chemPts, int eeePts, int archiPts) {
        this.eventName = eventName;
        this.desc = desc;
        Image = image;
        this.venue = venue;
        this.csePts = csePts;
        this.ecePts = ecePts;
        this.mechPts = mechPts;
        this.civPts = civPts;
        this.metaPts = metaPts;
        this.chemPts = chemPts;
        this.eeePts = eeePts;
        this.archiPts = archiPts;
    }

    
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

    public String getVenue() {
        return venue;
    }

    public void setveVue(String venue) {
        this.venue = venue;
    }

    public int getCsePts() {
        return csePts;
    }

    public void setCsePts(int csePts) {
        this.csePts = csePts;
    }

    public int getEcePts() {
        return ecePts;
    }

    public void setEcePts(int ecePts) {
        this.ecePts = ecePts;
    }

    public int getmechPts() {
        return mechPts;
    }

    public void setmechPts(int mechPts) {
        this.mechPts = mechPts;
    }

    public int getCivPts() {
        return civPts;
    }

    public void setCivPts(int civPts) {
        this.civPts = civPts;
    }

    public int getMetaPts() {
        return metaPts;
    }

    public void setMetaPts(int metaPts) {
        this.metaPts = metaPts;
    }

    public int getChemPts() {
        return chemPts;
    }

    public void setChemPts(int chemPts) {
        this.chemPts = chemPts;
    }

    public int getEeePts() {
        return eeePts;
    }

    public void setEeePts(int eeePts) {
        this.eeePts = eeePts;
    }

    public int getArchiPts() {
        return archiPts;
    }

    public void setArchiPts(int archiPts) {
        this.archiPts = archiPts;
    }
}
