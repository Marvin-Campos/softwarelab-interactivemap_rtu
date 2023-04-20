package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_menu);
    }
}