package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.concurrent.Executor;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Login_fragment extends Fragment {

    Button loginButton_, goToRegisterButton_;
    EditText email_, password_;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient mGoogleSignInClient;
    SignInButton signInButton;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton_ = view.findViewById(R.id.button_login);
        goToRegisterButton_ = view.findViewById(R.id.button_goToRegister);
        email_ = view.findViewById(R.id.username_login);
        password_ = view.findViewById(R.id.password_login);
        firebaseAuth = FirebaseAuth.getInstance();
        signInButton = view.findViewById(R.id.google_signin);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });


        goToRegisterButton_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });

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
                } else {

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                            new OnCompleteListener< AuthResult >() {
                                @Override
                                public void onComplete(@NonNull Task< AuthResult > task) {
                                    // is the logindsuccessful?
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "The user is successfully logged in",
                                                Toast.LENGTH_SHORT).show();
                                        getActivity().finish();

                                        startActivity(new Intent(getActivity(), ProfileActivity.class));
                                    } else {
                                        Toast.makeText(getActivity(), "Error" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }


            }
        });

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 101) {
            Task< GoogleSignInAccount > task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);

                firebaseAuthWithGoogle(account);

            } catch (ApiException e) {
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, new OnCompleteListener< AuthResult >() {
                    @Override
                    public void onComplete(@NonNull Task< AuthResult > task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent intent = new Intent(getActivity(), ProfileActivity.class);
                            startActivity(intent);
                            //getActivity().finish();
                            Toast.makeText(getActivity(), "User is successfully logged in",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "User could not log in",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                });
    }





 /*

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
*/
}
