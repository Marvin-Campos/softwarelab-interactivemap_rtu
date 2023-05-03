package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Collections;
import java.util.Vector;

public class MainMapActivity extends AppCompatActivity {

    String[] buildings = { "Select Building", "Building 1", "Building 2", "Building 3" };
    String[] building1Rooms = { "B1 Room 1", "B1 Room 2", "B1 Room 3"};
    String[] building2Rooms = { "B2 Room 1", "B2 Room 2", "B2 Room 3"};
    String[] building3Rooms = { "B3 Room 1", "B3 Room 2", "B3 Room 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_map);

        Spinner selectBuildingSpinner = (Spinner) findViewById(R.id.selectbuilding);
        ArrayAdapter<String> buildingAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, buildings);
        buildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectBuildingSpinner.setAdapter(buildingAdapter);

        Vector<String> rooms = new Vector<String>();
        rooms.add("Select Room");
        Spinner selectRoomSpinner = (Spinner) findViewById(R.id.selectroom);
        ArrayAdapter<String> roomAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rooms);
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRoomSpinner.setAdapter(roomAdapter);

        selectBuildingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String buildingSelected = selectBuildingSpinner.getSelectedItem().toString();

                selectRoomSpinner.setEnabled(true);
                rooms.clear();
                rooms.add("Select Room");
                if(buildingSelected.equals(buildings[1])) {
                    Collections.addAll(rooms, building1Rooms);
                    System.out.println("building 1 selected");
                } else if (buildingSelected.equals(buildings[2])) {
                    Collections.addAll(rooms, building2Rooms);
                } else if (buildingSelected.equals(buildings[3])) {
                    Collections.addAll(rooms, building3Rooms);
                } else {
                    selectRoomSpinner.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }
}