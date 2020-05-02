package com.example.androidexam.Model;

import com.example.androidexam.Model.Volume;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//using Gson to handle the conversion of the JSON string into a Java object (i.e. Deserialization).
// therefor @SerializedName and @Expose annotations offered by Gson for this purpose.
public class VolumeResponse {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("items")
    @Expose
    List< Volume > items = null;

    @SerializedName("totalItems")
    @Expose
    int totalItems;

    public String getKind() {
        return kind;
    }

    public List<Volume> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }

}
