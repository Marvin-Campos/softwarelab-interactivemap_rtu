package com.example.interactivenavigationrtumap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private Button enterButton;
    private Button creditButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_menu);

        enterButton = findViewById(R.id.enterbutton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterMainMap();
            }
        });

        creditButton = findViewById(R.id.creditbutton);
        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCredit();
            }
        });

        exitButton = findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitApp();
            }
        });
    }

    private void enterMainMap() {
        Intent mainMapActivity = new Intent(this, MainMapActivity.class);
        startActivity(mainMapActivity);
    }

    private void openCredit() {
        Intent creditActivity = new Intent(this, CreditActivity.class);
        startActivity(creditActivity);
    }

    private void exitApp() {
        finish();
        System.exit(0);
    }
}