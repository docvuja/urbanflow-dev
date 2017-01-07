package com.example.jeremy.urbanflow.Beans;

import java.util.Date;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class Element {
    private String title;
    private String image;
    private String description;
    private Date date;

    public Element()
    {}

    public Element(String title, String image, String description, Date date) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
