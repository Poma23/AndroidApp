package com.example.androidexam.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidexam.Model.VolumeResponse;
import com.example.androidexam.Repository.GoogleAPI_Repository;

public class GoogleAPI_ViewModel extends AndroidViewModel {

    private GoogleAPI_Repository bookRepository;
    private LiveData< VolumeResponse > volumesResponseLiveData;

    public GoogleAPI_ViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        bookRepository = new GoogleAPI_Repository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword) {
       bookRepository.searchVolumes(keyword);
    }

    public LiveData< VolumeResponse > getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}