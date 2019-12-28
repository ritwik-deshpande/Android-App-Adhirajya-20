package com.example.ritwik.ig20;

import java.util.List;

public class EventGroup {

    String group_name;
    String image;
    List<Event> events;

    public EventGroup(String group_name, String image, List<Event> events) {
        this.group_name = group_name;
        this.image = image;
        this.events = events;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
