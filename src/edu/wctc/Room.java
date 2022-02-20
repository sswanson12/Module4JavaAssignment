package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList = new ArrayList<>();

    public Room(double width, double length, double height) {
        wallList.add(new Wall(width, height));
        wallList.add(new Wall(width, height));
        wallList.add(new Wall(length, height));
        wallList.add(new Wall(length, height));
    }

    public double getArea(){
        double area = 0;

        for (Wall wall : wallList){
            area += wall.getArea();
        }

        return area;
    }

    @Override
    public String toString(){
        return "" + this.getArea();
    }
}
