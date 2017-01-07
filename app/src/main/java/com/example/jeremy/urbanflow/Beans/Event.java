package com.example.jeremy.urbanflow.Beans;

import java.util.Date;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class Event extends Element {
    private String organizer;
    private Date eventDate;
    private String place;

    public Event(String title, String image, String description, Date date, String organizer, Date eventDate, String place) {
        super(title, image, description, date);
        this.organizer = organizer;
        this.eventDate = eventDate;
        this.place = place;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        String res = String.format("%s \n\n%s : %s \n%s : %s \n%s : %s \n\n%s",
                getTitle(), "Organisé par", organizer, "Date", eventDate, "Lieu", place, getDescription());
        return res;
    }
}
