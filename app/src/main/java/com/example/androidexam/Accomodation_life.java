package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.AccomodationLife_Model;
import com.example.androidexam.ViewModels.AccomodationLife_ViewModel;


public class Accomodation_life extends Fragment {

    ImageButton visaButton, healthButton;
    TextView title, text;
    AccomodationLife_ViewModel lifeViewModel;

    public Accomodation_life() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accomodation_life, container, false);

        visaButton = view.findViewById(R.id.imgVisa);
        healthButton = view.findViewById(R.id.imgHealth);
       // title = view.findViewById(R.id.lifeTitle);
        text = view.findViewById(R.id.lifeText);
        lifeViewModel = new ViewModelProvider(this).get(AccomodationLife_ViewModel.class);
        lifeViewModel.getLifeModel().observe(getActivity(), new Observer< AccomodationLife_Model >() {
            @Override
            public void onChanged(AccomodationLife_Model accomodationLife_model) {
                lifeViewModel.getLifeModel();
            }
        });



        visaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(),Visa.class);
                startActivity(intent1);
            }
        });

        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),Health.class);
                startActivity(intent2);
            }
        });





        return view;
    }
}
