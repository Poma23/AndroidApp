package com.example.androidexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidexam.Model.AccomodationWork_Model;
import com.example.androidexam.ViewModels.AccomodationWork_ViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class Accomodation_work extends Fragment {
    Button jobsearch;
    ImageView image;
    TextView text;
    AccomodationWork_ViewModel work_viewModel;

    public Accomodation_work() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_accomodation_work, container, false);

        jobsearch = view.findViewById(R.id.workJobsearch);
        image = view.findViewById(R.id.workImage);
        text = view.findViewById(R.id.workText);
        work_viewModel = new ViewModelProvider(this).get(AccomodationWork_ViewModel.class);

        work_viewModel.getWorkModel().observe(getActivity(), new Observer< AccomodationWork_Model >() {
            @Override
            public void onChanged(AccomodationWork_Model accomodationWork_model) {
                work_viewModel.getWorkModel();
            }
        });

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
