package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.Study_option_Model;

public class StudyOption_ViewModel extends ViewModel {

    private LiveData< Study_option_Model > studyOptionModel= new MutableLiveData<>();

    public LiveData< Study_option_Model > getStudyOptionModel()
    {
        return studyOptionModel;
    }
}
