package com.example.ritwik.ig20;

import java.util.List;

class Department {
    String departmentName;
    List<Double> dailyScores;
    List<Double> enthuPoints;

    public Department(){

    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Double> getDailyScores() {
        return dailyScores;
    }

    public void setDailyScores(List<Double> dailyScores) {
        this.dailyScores = dailyScores;
    }
//    public int getDay1score() {
//        return day1score;
//    }
//
//    public void setDay1score(int day1score) {
//        this.day1score = day1score;
//    }

    public List<Double> getEnthuPoints() {
        return enthuPoints;
    }

    public void setEnthuPoints(List<Double> enthuPoints) {
        this.enthuPoints = enthuPoints;
    }

    public Department(String departmentName, List<Double> dailyscore, List<Double> enthuPoints) {
        this.departmentName = departmentName;
        this.dailyScores  =  dailyscore;
        this.enthuPoints = enthuPoints;
    }
}
