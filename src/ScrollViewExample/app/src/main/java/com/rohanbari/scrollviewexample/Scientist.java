package com.rohanbari.scrollviewexample;

public class Scientist {
    private final int image;
    private final String name;
    private final String description;

    public Scientist(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
