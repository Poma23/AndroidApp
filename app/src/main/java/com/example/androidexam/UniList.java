package com.example.androidexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidexam.Adaptor.Uni_Adaptor;
import com.example.androidexam.Model.UniListModel;
import com.example.androidexam.ViewModels.UniListViewModel;

import java.util.List;

public class UniList extends AppCompatActivity {

    private UniListViewModel uniListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_list);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView_Uni);
        // will take care of items be placed below each other
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final Uni_Adaptor adaptor = new Uni_Adaptor();
        recyclerView.setAdapter(adaptor);

        uniListViewModel = new ViewModelProvider(this).get(UniListViewModel.class);

        // every time onchanged is triggere and the data is changed our adaptor will update the list data set
        uniListViewModel.getAllUnies().observe(this, new Observer< List< UniListModel > >() {
            @Override
            public void onChanged(List< UniListModel > unies) {
                //update recyclerview
                adaptor.setUni(unies);

            }
        });


    }
}
