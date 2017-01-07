package com.example.jeremy.urbanflow.Beans;

import java.util.Date;

/**
 * Created by Jeremy on 14/06/2016.
 */
public class Video extends Element {
    private String videoTitle;
    private String videoDescription;
    private String thumbnailURL;
    private String id;

    public Video()
    {}

    public Video(String title, String image, String description, Date date) {
        super(title, image, description, date);
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String res = String.format("%s \n\n%s \n%s",
                getTitle(),
                getDescription(),
                "https://youtu.be/" + id);
        return res;
    }
}
