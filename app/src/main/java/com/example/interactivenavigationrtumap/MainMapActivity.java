package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainMapActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_map);

        String[] buildings = { "Select Building", "Building 1", "Building 2", "Building 3" };
        Spinner selectBuildingSpinner = (Spinner) findViewById(R.id.selectbuilding);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, buildings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectBuildingSpinner.setAdapter(adapter);
    }
}