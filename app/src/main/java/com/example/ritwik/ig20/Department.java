package com.example.ritwik.ig20;

import java.util.List;

class Department {
    String departmentName;
    List<Integer> dailyScores;
    List<Integer> enthuPoints;

    public Department(){

    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Integer> getDailyScores() {
        return dailyScores;
    }

    public void setDailyScores(List<Integer> dailyScores) {
        this.dailyScores = dailyScores;
    }
//    public int getDay1score() {
//        return day1score;
//    }
//
//    public void setDay1score(int day1score) {
//        this.day1score = day1score;
//    }

    public List<Integer> getEnthuPoints() {
        return enthuPoints;
    }

    public void setEnthuPoints(List<Integer> enthuPoints) {
        this.enthuPoints = enthuPoints;
    }

    public Department(String departmentName, List<Integer> dailyscore, List<Integer> enthuPoints) {
        this.departmentName = departmentName;
        this.dailyScores  =  dailyscore;
        this.enthuPoints = enthuPoints;
    }
}
