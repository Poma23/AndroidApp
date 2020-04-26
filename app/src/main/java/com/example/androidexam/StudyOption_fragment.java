package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class StudyOption_fragment extends Fragment
{
    ImageButton uni, uniCollage, art, maritime;
    Button list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study_options, container, false);

        view.findViewById(R.id.imageButton_uni).setOnClickListener(myListener);
        view.findViewById(R.id.imageButton_university_colegae).setOnClickListener(myListener);
        view.findViewById(R.id.imageButtonFineArt).setOnClickListener(myListener);
        view.findViewById(R.id.imageButtonMaritimeEducation).setOnClickListener(myListener);
        view.findViewById(R.id.button_UniList).setOnClickListener(myListener);

        return view;
    }

    private final View.OnClickListener myListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
             switch (v.getId())
             {
                 case R.id.imageButton_uni:
                     Intent intent= new Intent(getActivity(), University.class);
                     startActivity(intent);
                     break;

                 case R.id.imageButton_university_colegae:
                     Intent intent2= new Intent(getActivity(), University_collage.class);
                     startActivity(intent2);
                     break;

                 case R.id.imageButtonFineArt:
                     Intent intent3= new Intent(getActivity(), Artistic.class);
                     startActivity(intent3);
                     break;
                 case R.id.imageButtonMaritimeEducation:
                     Intent intent4= new Intent(getActivity(), Maritime.class);
                     startActivity(intent4);
                     break;
                 case R.id.button_UniList:
                     Intent intent5= new Intent(getActivity(),UniList.class);
                     startActivity(intent5);
             }

        }
    };


}
