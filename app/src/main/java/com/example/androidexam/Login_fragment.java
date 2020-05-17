package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class Login_fragment extends Fragment {


    private FirebaseAuth _mFirebaseAuth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener _mAuthListener;
    public static final int RC_SIGN_IN = 10;

    // Choose authentication providers
    List< AuthUI.IdpConfig > providers = Arrays.asList(
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

        if (user != null) {
            Toast.makeText(getActivity(), "welcome, You are already logged in",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), MainActivity.class));
        } else {
            // Create and launch sign-in intent
            startActivityForResult(
                    AuthUI.getInstance().
                            createSignInIntentBuilder().
                            setAvailableProviders(providers).setIsSmartLockEnabled(false).
                            build(), RC_SIGN_IN);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IdpResponse response = IdpResponse.fromResultIntent(data);
        if (requestCode == RC_SIGN_IN) {

            if (resultCode == RESULT_OK) {
                Toast.makeText(getContext(), "You are now signed in",
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), MainActivity.class));

            } else {
                if (response == null) {
                    return;
                }
                if (response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    return;
                }
            }
        }
    }
}
