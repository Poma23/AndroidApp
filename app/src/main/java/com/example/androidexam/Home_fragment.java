package com.example.androidexam;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Home_fragment extends Fragment
{
    @Nullable
    @Override
    //show the fragment we are in:
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        view.findViewById(R.id.Button_apply).setOnClickListener(myListener);
        view.findViewById(R.id.button_scholarship).setOnClickListener(myListener);

        return view;
    }
    private final View.OnClickListener myListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            int id = v.getId();
            switch (id)
            {
                case R.id.Button_apply:
                    Intent intent = new Intent(getActivity(), Apply.class);
                    startActivity(intent);
                    break;
                case R.id.button_scholarship:
                    Intent intent1 = new Intent(getActivity(), Scholar.class);
                    startActivity(intent1);
                    break;


            }
        }
    };


}
