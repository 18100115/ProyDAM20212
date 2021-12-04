package com.example.proyectaso.ui.fragments;

import java.io.Serializable;

public class ListElement implements Serializable {
    public int Image;
    public String color;
    public String name;
    public String city;
    public String status;

    public ListElement(int image, String color, String name, String city, String status) {
        Image = image;
        this.color = color;
        this.name = name;
        this.city = city;
        this.status = status;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
