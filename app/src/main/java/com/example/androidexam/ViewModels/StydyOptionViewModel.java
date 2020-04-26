package com.example.androidexam.ViewModels;

import android.widget.VideoView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.StudyOpteionModel;

public class StydyOptionViewModel extends ViewModel {

    String name, type, address;

    public StydyOptionViewModel(){}

    public StydyOptionViewModel(StudyOpteionModel studyOpteionModel) {
        this.name = name;
        this.type = type;
        this.address = address;
    }
}
