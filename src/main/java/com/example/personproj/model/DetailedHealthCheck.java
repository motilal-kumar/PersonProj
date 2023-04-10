package com.example.personproj.model;


public class DetailedHealthCheck extends HealthCheck {

    private String currentTime;

    public DetailedHealthCheck(String currentTime, String status) {
        super(status);
        this.currentTime = currentTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
