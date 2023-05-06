package com.example.interactivenavigationrtumap;

public class Building {
    private String name;
    private Room[] rooms;

    public Building(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public Room[] getRooms() {
        return rooms;
    }
}
