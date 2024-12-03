package com.example.projecgestionevenements;

public class Event {
    private String title;
    private String description;
    private String date;

    public Event() {
        // Required empty constructor for Firebase
    }

    public Event(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
