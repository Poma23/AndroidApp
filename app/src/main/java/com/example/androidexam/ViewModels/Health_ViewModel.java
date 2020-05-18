package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.Health_Model;

public class Health_ViewModel extends ViewModel {

    private LiveData< Health_Model > healthModel= new MutableLiveData<>();
    public LiveData< Health_Model > getHealth()
    {
        return healthModel;
    }

}
