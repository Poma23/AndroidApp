package com.example.androidexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Accomodation_work extends Fragment {
    Button jobsearch;

    public Accomodation_work() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_accomodation_work, container, false);

        jobsearch = view.findViewById(R.id.jobsearch);

        jobsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = Intent.ACTION_VIEW;
                Uri uri = Uri.parse("https://www.jobindex.dk");
                Intent intent = new Intent(action, uri);
                startActivity(intent);
            }
        });
   return view;

    }
}
