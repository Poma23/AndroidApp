package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.Home_Model;

public class Home_viewModel extends ViewModel {
    private LiveData< Home_Model > homeModel= new MutableLiveData<>();

    public LiveData< Home_Model > getHome()
    {
        return homeModel;
    }
}
