package com.tourian86;

public class TimeMS {

    int hours;
    int minutes;
    int seconds;

    public TimeMS(int seconds){
        hours = 0;
        minutes = 0;
        this.seconds = seconds;
    }

    public TimeMS(int minutes, int seconds){
        hours = 0;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public TimeMS(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public TimeMS(double hours){
        if(hours > 0 && hours < 1){
            hours = 0 ;
        }
        else
        {
            this.hours = (int)hours;
            hours -= this.hours;
        }
        hours *= 60;
        minutes = (int)hours;

        hours -= minutes;
        hours *= 60;

        seconds = (int)hours;
    }

    public int hours() {
        return hours;
    }

    public int minutes() {
        return minutes;
    }

    public int seconds() {
        return seconds;
    }

    public double totalHours(){
        double totalHours = seconds / 60;
        totalHours += minutes;
        totalHours /= 60;
        totalHours += hours;
        return totalHours;
    }
}
