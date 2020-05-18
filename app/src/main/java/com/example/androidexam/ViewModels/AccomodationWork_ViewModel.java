package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.AccomodationWork_Model;

public class AccomodationWork_ViewModel extends ViewModel {

    private LiveData< AccomodationWork_Model > workModel= new MutableLiveData<>();

    public LiveData< AccomodationWork_Model > getWorkModel()
    {
        return workModel;
    }

}
