package com.nsnirjash.androidproject.model;

public class NotificationModel {

    private  int id;
    private  String date;
    private String news;

    public NotificationModel(int id) {

    }

    public NotificationModel(int id, String date, String news) {
        this.id = id;
        this.date = date;
        this.news = news;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
