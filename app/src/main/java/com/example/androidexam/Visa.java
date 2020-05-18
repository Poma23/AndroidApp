package com.example.androidexam;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.Visa_Model;
import com.example.androidexam.ViewModels.Visa_ViewModel;

public class Visa extends AppCompatActivity {

    TextView text1, text2, title1, title2;
    ImageView visaImage;
    Visa_ViewModel visaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa);

        text1 = findViewById(R.id.visaText1);
        text2 = findViewById(R.id.visaText2);
        title1 = findViewById(R.id.visaTitle1);
        title2 = findViewById(R.id.visaTitle2);
        visaViewModel = new ViewModelProvider(this).get(Visa_ViewModel.class);

        visaViewModel.getVisa().observe(this, new Observer< Visa_Model >() {
            @Override
            public void onChanged(Visa_Model visa_model) {
                visaViewModel.getVisa();
            }
        });


    }
}
