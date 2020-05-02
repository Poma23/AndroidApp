package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ApplicationDeadline_fragment extends Fragment {

    ImageView deadlineImage;
    TextView deadline;
    TextView apply;
    Button apllyImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deadline, container, false);

        deadlineImage = view.findViewById(R.id.deadlineImage);
        deadline = view.findViewById(R.id.deadlineText);
        apply = view.findViewById(R.id.applyNowText);
        apllyImage = view.findViewById(R.id.imageButton);

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
