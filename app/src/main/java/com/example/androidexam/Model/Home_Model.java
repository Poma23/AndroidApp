package com.example.androidexam.Model;

import android.widget.ImageView;

public class Home_Model {
    private String title;
    private String text;
    private ImageView image;


    public Home_Model(String title, String text, ImageView image) {
        this.title = title;
        this.text = text;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ImageView getImage() { return image;}

    public void setImage(ImageView image) { this.image = image; }

}
