package com.example.ritwik.ig20;

public class Developer {
    String name;
    String year;
    int image;
    String ld;
    String git;
    String gmail;
    String post;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Developer(String name, String year, int image, String ld, String git, String gmail,String post) {
        this.name = name;
        this.year = year;
        this.image = image;
        this.ld = ld;
        this.git = git;
        this.gmail = gmail;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLd() {
        return ld;
    }

    public void setLd(String ld) {
        this.ld = ld;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }


}
