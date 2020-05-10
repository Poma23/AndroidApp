package com.example.androidexam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidexam.Adapter.GoogleAPI_Adapter;
import com.example.androidexam.Model.VolumeResponse;
import com.example.androidexam.ViewModels.GoogleAPI_ViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class BookSearch extends AppCompatActivity {

    private GoogleAPI_ViewModel viewModel;
    private GoogleAPI_Adapter adapter;
    private TextInputEditText keywordEditText;
    private Button searchButton;
    private RecyclerView recyclerView;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_booksearch);

        recyclerView = findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        keywordEditText = findViewById(R.id.fragment_booksearch_keyword);
        searchButton = findViewById(R.id.fragment_booksearch_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

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

    private void performSearch() {
        String keyword = keywordEditText.getEditableText().toString();

        viewModel.searchVolumes(keyword);
    }








}
