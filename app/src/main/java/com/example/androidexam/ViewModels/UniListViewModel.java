package com.example.androidexam.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidexam.Model.UniListModel;
import com.example.androidexam.Repository.UniListRepository;

import java.util.List;

//in android viewmodel is a subclass of viewModel but we get passed the application
//Room requires a Context object
//we can not PASS THE ACTIVITY FROM THE VIEW TO THE VIEWMODEL!!
public class UniListViewModel extends AndroidViewModel {

    private UniListRepository uniListRepository;
    private LiveData< List< UniListModel > > allUnies;

    public UniListViewModel(@NonNull Application application) {
        super(application);
        uniListRepository = new UniListRepository(application);
        allUnies = uniListRepository.getAllUni();
    }

    public void insert(UniListModel uniListModel) {
        uniListRepository.insert(uniListModel);
    }

    public void update(UniListModel uniListModel) {
        uniListRepository.update(uniListModel);
    }

    public void delete(UniListModel uniListModel) {
        uniListRepository.delete(uniListModel);
    }

    public void deletAll() {
        uniListRepository.deleteAll();
    }

    public LiveData< List< UniListModel > > getAllUnies() {
        return allUnies;
    }


}
