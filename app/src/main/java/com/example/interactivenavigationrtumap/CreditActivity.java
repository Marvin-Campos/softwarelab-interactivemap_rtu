package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Credits");
        //in androidmanifest.xml the back button is set to parent class main menu activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_credit);
    }
}