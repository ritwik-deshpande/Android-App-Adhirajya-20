package com.example.ritwik.ig20;

class Department {
    String departmentName;
    int dailyScores[];
    int enthuPoints[];


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int[] getDailyScores() {
        return dailyScores;
    }

    public void setDailyScores(int[] dailyScores) {
        this.dailyScores = dailyScores;
    }
//    public int getDay1score() {
//        return day1score;
//    }
//
//    public void setDay1score(int day1score) {
//        this.day1score = day1score;
//    }

    public int[] getEnthuPoints() {
        return enthuPoints;
    }

    public void setEnthuPoints(int[] enthuPoints) {
        this.enthuPoints = enthuPoints;
    }

    public Department(String departmentName, int dailyscore[], int enthuPoints[]) {
        this.departmentName = departmentName;
        this.dailyScores  =  dailyscore;
        this.enthuPoints = enthuPoints;
    }
}
