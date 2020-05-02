package com.example.androidexam.Model;

//this class is for the items in google books API.
//using Gson to handle the conversion of the JSON string into a Java object (i.e. Deserialization).
// therefor @SerializedName and @Expose annotations offered by Gson for this purpose.

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Volume {

    @SerializedName("selfLink")
    @Expose
    private String selfLink;

    @SerializedName("volumeInfo")
    @Expose
    VolumeInfo volumeInfo;

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
