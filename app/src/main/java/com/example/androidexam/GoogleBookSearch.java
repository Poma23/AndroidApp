package com.example.androidexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidexam.Adapter.GoogleAPI_Adapter;
import com.example.androidexam.Model.VolumeResponse;
import com.example.androidexam.ViewModels.GoogleAPI_ViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class GoogleBookSearch extends Fragment {

    private GoogleAPI_ViewModel viewModel;
    private GoogleAPI_Adapter adapter;
    private TextInputEditText keywordEditText;
    private Button searchButton;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_booksearch, container, false);


        recyclerView = view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        keywordEditText = view.findViewById(R.id.fragment_booksearch_keyword);
        searchButton = view.findViewById(R.id.fragment_booksearch_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        return view;
    }

    private void performSearch() {
        String keyword = keywordEditText.getEditableText().toString();

        viewModel.searchVolumes(keyword);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        adapter = new GoogleAPI_Adapter();
        viewModel = new ViewModelProvider(this).get(GoogleAPI_ViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, new Observer< VolumeResponse >() {
            @Override
            public void onChanged(VolumeResponse volumeResponse) {
                if (volumeResponse != null) {
                    adapter.setResults(volumeResponse.getItems());
                }
            }
        });
    }


}
