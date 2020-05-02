package com.example.androidexam.Model;

import com.example.androidexam.Model.VolumeImageLinks;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//using Gson to handle the conversion of the JSON string into a Java object (i.e. Deserialization).
// therefor @SerializedName and @Expose annotations offered by Gson for this purpose.
public class VolumeInfo {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("imageLinks")
    @Expose
    private VolumeImageLinks imageLinks;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public VolumeImageLinks getImageLinks() {
        return imageLinks;
    }
}
