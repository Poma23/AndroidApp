package com.example.androidexam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//using Gson to handle the conversion of the JSON string into a Java object (i.e. Deserialization).
// therefor @SerializedName and @Expose annotations offered by Gson for this purpose.
public class VolumeImageLinks {
    @SerializedName("smallThumbnail")
    @Expose
    private String smallThumbnail;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}