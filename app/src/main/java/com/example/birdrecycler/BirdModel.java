package com.example.birdrecycler;
public class BirdModel {
    private int imageID;
    private String name;

    public BirdModel(int imageID, String name) {
        this.imageID = imageID;
        this.name = name;
    }

    public int getImage() {
        return imageID;
    }

    public String getName() {
        return name;
    }
}