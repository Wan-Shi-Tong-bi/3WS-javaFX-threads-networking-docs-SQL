/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cUebung.model;

import java.time.LocalDate;

/**
 *
 * @author jerem
 */
public class Wetter {
    private LocalDate date;
    private int tempDay;
    private int tempNight;
    private String weather;

    public Wetter(LocalDate date, int tempDay, int tempNight, String weather) {
        this.date = date;
        this.tempDay = tempDay;
        this.tempNight = tempNight;
        this.weather = weather;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTempDay() {
        return tempDay;
    }

    public void setTempDay(int tempDay) {
        this.tempDay = tempDay;
    }

    public int getTempNight() {
        return tempNight;
    }

    public void setTempNight(int tempNight) {
        this.tempNight = tempNight;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

//    @Override
//    public String toString() {
//        return date.getDayOfWeek().name() + "\n" + date + "\n" + tempDay + "\n" + tempNight;
//    }
    
    
}
