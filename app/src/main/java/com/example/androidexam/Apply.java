package com.example.androidexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Apply extends AppCompatActivity {

    TextView titleApply;
    ImageButton optagelseDk;
    TextView textApply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        titleApply = findViewById(R.id.applyNow_textview);
        optagelseDk = findViewById(R.id.imageButton_optagelse);
        textApply = findViewById(R.id.optagelseText);

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
