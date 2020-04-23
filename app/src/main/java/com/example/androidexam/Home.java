package com.example.androidexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity implements View.OnClickListener {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton apply = findViewById(R.id.Button_apply);
        ImageButton scholar = findViewById(R.id.button_scholarship);

        apply.setOnClickListener(this);
        scholar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Button_apply:
                Intent intentApply= new Intent(this, Apply.class);
                startActivity(intentApply);
                break;

            case R.id.button_scholarship:
                Intent intentScholar= new Intent(this, Scholar.class);
                startActivity(intentScholar);
                break;

        }

    }
}
