package com.example.androidexam;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LivingCost extends AppCompatActivity {

    Button googleSearchButton;
    EditText googleText;
   // BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_cost);

        googleSearchButton = findViewById(R.id.button_googleBooks);
        googleText = findViewById(R.id.editText_googleBooks);
/*
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        bookViewModel.getBook().observe(this, new Observer< BookModel >() {
            @Override
            public void onChanged(BookModel bookModel) {
                BookViewModel.requestBook(googleText.getText().toString());

            }
        });

 */


    }
}
