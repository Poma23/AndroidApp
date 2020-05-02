package com.example.androidexam;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Health extends AppCompatActivity {

    Button health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
/*
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = Intent.ACTION_VIEW;
                Uri uri = Uri.parse("https://www.nyidanmark.dk/en-GB");
                Intent intent = new Intent(action, uri);
                startActivity(intent);
            }
        });

*/
    }
}
