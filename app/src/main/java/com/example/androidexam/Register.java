package com.example.androidexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText name_,email_, password_;
    Button register;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_ = findViewById(R.id.name_Register);
        email_ = findViewById(R.id.username_register);
        password_ = findViewById(R.id.password_Register);
        register = findViewById(R.id.button_Register);
        firebaseAuth = FirebaseAuth.getInstance();
/*
        //validate that the user is not already logedin
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Home_fragment.class));
             finish();
        }

 */

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_.getText().toString();
                String password = password_.getText().toString();

                //validate That feilds are not empty
                if (TextUtils.isEmpty(email)) {
                    email_.setError("Email is required !");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    password_.setError("Password is required!");
                    return;
                }
                if (password.length() < 6) {
                    password_.setError("Password must be minimum 6 character");
                    return;
                }


                //Register and listen if the registeration has been successsfull or not
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener< AuthResult >() {
                            @Override
                            public void onComplete(@NonNull Task< AuthResult > task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "The user is created now"
                                            , Toast.LENGTH_SHORT).show();
                                    //send user to homeacivity
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    Toast.makeText(Register.this, "Error, user is not created"
                                            + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });


    }
}
