package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.Study_option_Model;
import com.example.androidexam.ViewModels.StudyOption_ViewModel;

public class StudyOption_fragment extends Fragment
{
    Button list;
    TextView title, text;
    StudyOption_ViewModel stViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study_options, container, false);

        list= view.findViewById(R.id.button_UniList);
        title= view.findViewById(R.id.StudyOptionTitle);
        text= view.findViewById(R.id.studyOptionText);
        stViewModel = new ViewModelProvider(this).get(StudyOption_ViewModel.class);

        stViewModel.getStudyOptionModel().observe(getActivity(), new Observer< Study_option_Model >() {
            @Override
            public void onChanged(Study_option_Model study_option_model) {
                stViewModel.getStudyOptionModel();
            }
        });


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),UniList.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
