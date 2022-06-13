package com.example.meditari.Mood;

public class moodCalendarModel {
    public String date, mood;

    public moodCalendarModel(String date, String mood){
        this.date=date;
        this.mood=mood;
    }

    public String getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
