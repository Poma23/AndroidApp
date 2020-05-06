package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class Login_fragment  extends Fragment {


    private FirebaseAuth _mFirebaseAuth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener _mAuthListener;
    public static final int RC_SIGN_IN= 1;



    // Choose authentication providers
    List< AuthUI.IdpConfig > providers= Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build()
    );
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        _mFirebaseAuth = FirebaseAuth.getInstance();
        user = _mFirebaseAuth.getCurrentUser();

        _mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override

            public void onAuthStateChanged(FirebaseAuth firebaseAuth){
                // check if  the user is signed in
                if( user != null){
                    Toast.makeText(getContext(),"You are already logged in",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getContext(), MainActivity.class));
                }else{
                    // Create and launch sign-in intent
                    startActivityForResult(
                            AuthUI.getInstance().
                                    createSignInIntentBuilder().
                                    setAvailableProviders(providers).setIsSmartLockEnabled(false).
                                    build(), RC_SIGN_IN);

                }

            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        _mFirebaseAuth.addAuthStateListener(_mAuthListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        _mFirebaseAuth.removeAuthStateListener(_mAuthListener);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

        //    if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                startActivity(new Intent(getContext(), Home_fragment.class));
                Toast.makeText(getContext(),"You are now signed in",
                        Toast.LENGTH_LONG).show();
                // ...
        //    } else {
                // Sign in failed.
        //        startActivity(new Intent(getActivity(), Login_fragment.class));
        //        Toast.makeText(getContext(),"You are now signed in failed",
        //                Toast.LENGTH_LONG).show();
          //  }
        }
    }

    public void signOut(View view) {
        AuthUI.getInstance().signOut(getContext()).addOnCompleteListener(
                new OnCompleteListener< Void >() {
                    @Override
                    public void onComplete(@NonNull Task< Void > task) {
                        Toast.makeText(getContext(),"You are now signed out",
                                Toast.LENGTH_LONG).show();
                        //finish();
                    }
                }
        );
    }
}



















