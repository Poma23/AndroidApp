package com.example.androidexam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser; // contain all the information about user
    TextView profile_name;
    TextView profile_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser= firebaseAuth.getCurrentUser();
        profile_name = findViewById(R.id.profile_name);
        profile_email = findViewById(R.id.profile_email);

        //profile_email.setText(firebaseUser.getEmail());
       // profile_name.setText(firebaseUser.getDisplayName());



    }

}
