package com.example.myapplication.model;

public class MovieModel {

    private String title;
    private String image;

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

    public MovieModel(String title, String image) {
        this.title = title;
        this.image = image;
    }
}
