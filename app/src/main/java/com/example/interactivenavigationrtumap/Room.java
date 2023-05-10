package com.example.interactivenavigationrtumap;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Room {
    private String name;
    private int floorNumber;
    private int pictureID;

    public Room(String name, int floorNumber, int pictureID) {
        this.name = name;
        this.floorNumber = floorNumber;
        this.pictureID = pictureID;
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

    public int getPictureID() {
        return pictureID;
    }
}
