package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_map);
    }
}