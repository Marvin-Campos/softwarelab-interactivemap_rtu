package com.example.interactivenavigationrtumap;

public class Room {
    private String name;
    private int floorNumber;

    public Room(String name, int floorNumber) {
        this.name = name;
        this.floorNumber = floorNumber;
    }

    public String getName() {
        return name;
    }

    public String getFloorNumber() {
        if(floorNumber == 0) { return "Whole Building"; }
        else if (floorNumber == 1) { return "1st";}
        else if (floorNumber == 2) { return "2nd";}
        else if (floorNumber == 3) { return "3rd";}
        else { return floorNumber + "th"; }

    }
}
