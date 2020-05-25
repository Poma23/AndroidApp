package com.example.androidexam.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.UniList_model;

public class uniList_ViewModel extends ViewModel {

    String name, type, address;

    public uniList_ViewModel(){}

    public uniList_ViewModel(UniList_model uniList_model) {
        this.name = name;
        this.type = type;
        this.address = address;
    }
}
