package com.example.androidexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.Health_Model;
import com.example.androidexam.ViewModels.Health_ViewModel;

public class Health extends AppCompatActivity {

    Button healthButton;
    Health_ViewModel health_viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        healthButton = findViewById(R.id.button_link_health);

        health_viewModel = new ViewModelProvider(this).get(Health_ViewModel.class);

        health_viewModel.getHealth().observe(this, new Observer< Health_Model >() {
            @Override
            public void onChanged(Health_Model health_model) {
                health_viewModel.getHealth();
            }
        });

        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = Intent.ACTION_VIEW;
                Uri uri = Uri.parse("https://www.nyidanmark.dk");
                Intent intent = new Intent(action, uri);
                startActivity(intent);
            }
        });


    }
}
