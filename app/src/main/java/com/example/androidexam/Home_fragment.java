package com.example.androidexam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import java.net.URI;

public class Home_fragment extends Fragment {
    Button logout;
        @Nullable
    @Override
    //show the fragment we are in:
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        logout = view.findViewById(R.id.button_logout);


        // temperary location for test logout:
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getActivity(), "Your are now logged out ", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Login_fragment()).commit();
            }
        });



        return view;
    }
}



        //***********************************************Video************************************************************/*
        /*

         VideoView video;
        String videoUrl = "https://www.youtube.com/watch?v=bIn5Bv5yMcM";
         ProgressDialog progressDialog;

        MediaController mediaController= new MediaController(getContext());
        video= view.findViewById(R.id.video);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
        Uri uri= Uri.parse("gs://studyindenmark2020.appspot.com/Why study in Denmark Here are some of our international students' reasons.mp4");
        video.setVideoURI(uri);
        video.start();
        */
        /**********************************************imagebutton*********************************************************

    /*

        view.findViewById(R.id.Button_apply).setOnClickListener(myListener);
        view.findViewById(R.id.button_scholarship).setOnClickListener(myListener);
        view.findViewById(R.id.button_logout).setOnClickListener(myListener);

        return view;
    }

    private final View.OnClickListener myListener = new View.OnClickListener() {
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.Button_apply:
                    Intent intent = new Intent(getActivity(), Apply.class);
                    startActivity(intent);
                    break;
                case R.id.button_scholarship:       //openning activity from fragment
                    Intent intent1 = new Intent(getActivity(), Scholar.class);
                    startActivity(intent1);
                    break;
                case R.id.button_logout:            //openning a fragment from fragment
                    FirebaseAuth.getInstance().signOut();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new Login_fragment()).commit();


                    //Intent intent2 = new Intent(getActivity(),Login_fragment.class);
                    //startActivity(intent2);
                    // finish();

            }
        }
    };

*/

