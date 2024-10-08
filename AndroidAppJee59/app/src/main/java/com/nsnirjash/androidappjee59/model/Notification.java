package com.nsnirjash.androidappjee59.model;

public class Notification {

    private  int id;
    private  String date;
    private String news;

    public Notification(int id) {

    }

    public Notification(int id, String date, String news) {
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
