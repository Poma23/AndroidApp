package com.example.androidexam.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "University")
public class UniListModel {

    @PrimaryKey(autoGenerate = true)
    private int id;     // automatickly encrement
    private String Title;
    private String Description;


    public UniListModel(String Title, String Description) {
        this.Title = Title;
        this.Description = Description;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }


}
