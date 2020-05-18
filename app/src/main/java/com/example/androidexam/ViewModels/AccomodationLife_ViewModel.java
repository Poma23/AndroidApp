package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.AccomodationLife_Model;

public class AccomodationLife_ViewModel extends ViewModel {

    private LiveData< AccomodationLife_Model > lifeModel= new MutableLiveData<>();

    public LiveData< AccomodationLife_Model > getLifeModel()
    {
        return lifeModel;
    }
}
