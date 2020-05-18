package com.example.androidexam.Model;

public class Visa_Model {
    private String title1, title2, text1, text2;

    public Visa_Model(String title1, String title2, String text1, String text2) {
        this.title1 = title1;
        this.title2 = title2;
        this.text1 = text1;
        this.text2 = text2;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
