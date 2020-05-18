package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.Application_deadline_Model;

public class ApplicationDeadline_viewModel extends ViewModel {

    private LiveData< Application_deadline_Model > AppDeadlineModel= new MutableLiveData<>();

    public LiveData< Application_deadline_Model > getDeadlineModel()
    {
        return AppDeadlineModel;
    }

}
