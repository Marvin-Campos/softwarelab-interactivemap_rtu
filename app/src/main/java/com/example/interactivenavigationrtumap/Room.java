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

    public int getFloorNumber() {
        return floorNumber;
    }
}
