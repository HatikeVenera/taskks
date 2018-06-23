package com.example.arslan.weather;


public class City {
    private String title, descr;

    public City() {
    }

    public City(String title, String descr) {
        this.title = title;
        this.descr = descr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
