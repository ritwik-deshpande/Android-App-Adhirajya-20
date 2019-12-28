package com.example.ritwik.ig20;

public class News {

    String news_text;
    String news_image;

    public News(String news_text, String news_image) {
        this.news_text = news_text;
        this.news_image = news_image;
    }

    public String getNews_text() {
        return news_text;
    }

    public void setNews_text(String news_text) {
        this.news_text = news_text;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }
}
