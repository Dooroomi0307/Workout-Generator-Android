package com.example.workout_generator.video_data_management;


import java.io.Serializable;

public class Video implements Serializable {

    private String id;
    private String link;
    private String title;
    private String gender;
    private String location;
    private Double duration;
    private String description;

    public Video(String id, String link, String title, String gender, String location, Double duration, String description) {
        this.id = id;
        this.link = link;
        this.title = title;
        this.gender = gender;
        this.location = location;
        this.duration = duration;
        this.description = description;
    }

    /*
        GETTERS AND SETTERS ------------------------------------
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
