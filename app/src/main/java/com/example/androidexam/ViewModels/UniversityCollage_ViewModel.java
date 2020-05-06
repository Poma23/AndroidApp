package com.example.androidexam.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.UniversityCollage_Model;

import java.util.ArrayList;
import java.util.List;

public class UniversityCollage_ViewModel  extends ViewModel {


    private MutableLiveData< List< UniversityCollage_Model > > universityCollageList;   //you can change the value of the data in MutableLiveData

    public UniversityCollage_ViewModel(){
        universityCollageList = new MutableLiveData<>();
        List<UniversityCollage_Model> newList = new ArrayList<>();
        universityCollageList.setValue(newList);
    }

    public LiveData<List<UniversityCollage_Model>> getAlluniversityCollages(){          //Returned to the View as LiveData to make the observed data immutable in the Activity/Fragment
        return universityCollageList;
    }

    public void addUniversityCollage(UniversityCollage_Model  universityCollage){
        List<UniversityCollage_Model> currentUniversityCollage = universityCollageList.getValue();
        currentUniversityCollage.add(universityCollage);
        universityCollageList.setValue(currentUniversityCollage);                       //Changes the value of the MutableLiveData and notifies any observers
    }

    public void deleteAllNotes(){
        List<UniversityCollage_Model> currentUniversityCollage
                = universityCollageList.getValue();                                     //Returns any data wrapped in LiveData
        currentUniversityCollage.clear();
        universityCollageList.setValue(currentUniversityCollage);
    }


}
