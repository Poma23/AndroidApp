package com.example.androidexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidexam.Model.UniListModel;
import com.example.androidexam.ViewModels.UniListViewModel;

import java.util.List;

public class UniList extends AppCompatActivity {
    private UniListViewModel uniListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_list);

        uniListViewModel = new ViewModelProvider(this).get(UniListViewModel.class);
        uniListViewModel.getAllUnies().observe(this, new Observer< List< UniListModel > >() {
            @Override
            public void onChanged(List< UniListModel > unies) {
                //update recyclerview
                Toast.makeText(UniList.this, "onchanged", Toast.LENGTH_SHORT).show();

            }
        });




    }
}
