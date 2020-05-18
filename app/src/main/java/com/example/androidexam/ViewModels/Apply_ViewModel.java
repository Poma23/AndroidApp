package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.Apply_Model;

public class Apply_ViewModel extends ViewModel {

    private LiveData< Apply_Model > applyModel= new MutableLiveData<>();

    public LiveData< Apply_Model > getApply()
    {
        return applyModel;
    }

}
