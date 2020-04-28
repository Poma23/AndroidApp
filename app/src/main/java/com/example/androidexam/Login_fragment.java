package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;

public class Login_fragment extends Fragment {

    EditText email_, password_;
    Button loginButton_, goToRegisterButton_;
    FirebaseAuth firebaseAuth;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

       email_=  view.findViewById(R.id.username_login);
       password_= view.findViewById(R.id.password_login);
       loginButton_=  view.findViewById(R.id.button_login);//.setOnClickListener(myListener);
       goToRegisterButton_= view.findViewById(R.id.button_goToRegister);//.setOnClickListener(myListener);
       firebaseAuth = FirebaseAuth.getInstance();

       loginButton_.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = email_.getText().toString();
               String password = password_.getText().toString();

               //validate That feilds are not empty
               if (TextUtils.isEmpty(email)) {
                   email_.setError("Email is required !");
                   return;
               } else if (TextUtils.isEmpty(password)) {
                   password_.setError("Password is required!");
                   return;
               } else if (password.length() < 6) {
                   password_.setError("Password must be minimum 6 character");
                   return;
               }
               //login


               firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                       new OnCompleteListener< AuthResult >() {
                           @Override
                           public void onComplete(@NonNull Task< AuthResult > task) {
                               // is the logindsuccessful?
                               if (task.isSuccessful()) {
                                   Toast.makeText(getActivity(), "You are now logged in",
                                           Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(getActivity(), MainActivity.class));
                               } else {
                                   Toast.makeText(getActivity(), "Error" + task.getException(),
                                           Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

           }
       });

    goToRegisterButton_.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), Register.class);
            startActivity(intent);
        }
    });
        return view;

    }

}
