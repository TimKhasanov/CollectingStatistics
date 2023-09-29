package com.example.CollectingStatistics.dto;

public class EventRequest {

    private int classifierId;
    private String description;

    public EventRequest(int classifierId, String description) {
        this.classifierId = classifierId;
        this.description = description;
    }

    public EventRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClassifierId() {
        return classifierId;
    }

    public void setClassifierId(int classifierId) {
        this.classifierId = classifierId;
    }
}
