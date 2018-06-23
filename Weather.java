package com.example.arslan.weather;

import android.graphics.Bitmap;
import android.media.Image;

public class Weather {
    Bitmap image ;
    String weather, city, descr;
    int temperature;

    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getDescr() {
        return descr;
    }
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public String getCity() { return city; }
    public void setCity(String city) {
        this.city = city;
    }
    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }
}
