package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.Application_deadline_Model;
import com.example.androidexam.ViewModels.ApplicationDeadline_viewModel;

public class ApplicationDeadline_fragment extends Fragment {

    ImageView deadlineImage;
    TextView deadline;
    TextView apply;
    ImageButton apllyImage;
    ApplicationDeadline_viewModel appViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deadline, container, false);

        deadlineImage = view.findViewById(R.id.deadlineImage);
        deadline = view.findViewById(R.id.deadlineText);
        apply = view.findViewById(R.id.applyNowText);
        apllyImage = view.findViewById(R.id.imageButton);
        appViewModel = new ViewModelProvider(this).get(ApplicationDeadline_viewModel.class);

        appViewModel.getDeadlineModel().observe(getActivity(), new Observer< Application_deadline_Model >() {
            @Override
            public void onChanged(Application_deadline_Model application_deadline_model) {
                appViewModel.getDeadlineModel();
            }
        });

        apllyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Apply.class);
                startActivity(intent);
            }
        });



        return view;
    }
}
