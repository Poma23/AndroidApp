package com.example.androidexam.Model;

public class StudyOpteionModel {

    String name, type, address;
    public StudyOpteionModel(String name, String type, String address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
