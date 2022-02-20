package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double width, double length, double height){
        roomList.add(new Room(width, length, height));
    }

    @Override
    public String toString(){
        String returnString = "";
        if (roomList.isEmpty()){
            return "There are no rooms added yet.";
        } else {
            for (Room room : roomList){
                returnString += "Room " + (roomList.indexOf(room) + 1) + ": " + room.getArea() + ", ";
            }
            returnString = returnString.substring(0, returnString.length() - 2);
        }
        return returnString;
    }
}
