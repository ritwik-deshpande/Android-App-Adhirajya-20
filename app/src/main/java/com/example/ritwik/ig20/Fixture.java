package com.example.ritwik.ig20;

import java.io.Serializable;

public class Fixture implements Serializable {
    String round;
    String date_venue;
    String result;
    String depts;

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getDate_venue() {
        return date_venue;
    }

    public void setDate_venue(String date_venue) {
        this.date_venue = date_venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDepts() {
        return depts;
    }

    public void setDepts(String depts) {
        this.depts = depts;
    }

    public Fixture(String round, String date_venue, String result, String depts) {
        this.round = round;
        this.date_venue = date_venue;
        this.result = result;
        this.depts = depts;
    }
}
