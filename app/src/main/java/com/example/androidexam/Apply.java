package com.example.androidexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.Apply_Model;
import com.example.androidexam.ViewModels.Apply_ViewModel;

public class Apply extends AppCompatActivity {

    TextView titleApply;
    ImageButton optagelseDk;
    TextView textApply;
    Apply_ViewModel applyViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        titleApply = findViewById(R.id.apply_title);
        optagelseDk = findViewById(R.id.apply_imagebutton);
        textApply = findViewById(R.id.applyText);
        applyViewModel = new ViewModelProvider(this).get(Apply_ViewModel.class);

        applyViewModel.getApply().observe(this, new Observer< Apply_Model >() {
            @Override
            public void onChanged(Apply_Model apply_model) {
                applyViewModel.getApply();
            }
        });

        optagelseDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = Intent.ACTION_VIEW;
                Uri uri = Uri.parse("https://www.optagelse.dk");
                Intent intent = new Intent(action, uri);
                startActivity(intent);
            }
        });


    }
}
