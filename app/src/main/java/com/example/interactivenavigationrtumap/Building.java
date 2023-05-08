package com.example.interactivenavigationrtumap;

public class Building {
    private String name;
    private Room[] rooms;
    private float scale;
    private float zoomRectCenterX;
    private float zoomRectCenterY;

    public Building(String name, Room[] rooms, float scale, float zoomRectCenterX, float zoomRectCenterY) {
        this.name = name;
        this.rooms = rooms;
        this.scale = scale;
        this.zoomRectCenterX = zoomRectCenterX;
        this.zoomRectCenterY = zoomRectCenterY;
    }

    public String getName() {
        return name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public float getScale() {
        return scale;
    }

    public float getZoomRectCenterX() {
        return zoomRectCenterX;
    }

    public float getZoomRectCenterY() {
        return zoomRectCenterY;
    }
}
