package com.example.androidexam.Model;

public class UniList_model {

    String name, type, address;
    public UniList_model(String name, String type, String address) {
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
