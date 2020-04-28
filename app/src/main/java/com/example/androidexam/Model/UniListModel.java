package com.example.androidexam.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "University")
public class UniListModel {

    @PrimaryKey(autoGenerate = true)
    private int id;     // automatickly encrement
    private String name;
    private String type;
    private String address;

    public UniListModel(String name, String type, String address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }


}
