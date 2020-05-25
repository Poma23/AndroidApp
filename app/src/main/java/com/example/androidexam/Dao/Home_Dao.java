package com.example.androidexam.Dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidexam.Model.Home_Model;

public class Home_Dao {
    private LiveData< Home_Model > homeModel = new MutableLiveData<>();
    private static Home_Dao instance;


    public Home_Dao() {
    }
}
