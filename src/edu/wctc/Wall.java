package edu.wctc;

import java.io.Serializable;

public class Wall implements Serializable {
    private double width;
    private double height;

    public Wall(double w, double h){
        width = w;
        height = h;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }
}
