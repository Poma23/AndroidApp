package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.Visa_Model;

public class Visa_ViewModel extends ViewModel {
    private LiveData< Visa_Model > visaModel= new MutableLiveData<>();

    public LiveData< Visa_Model > getVisa()
    {
        return visaModel;
    }
}
