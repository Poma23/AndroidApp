package com.example.androidexam.Model;

public class BookModel {
    private String title;
    private String author;
    private String language;

    public BookModel(String title, String author, String language) {
        this.title = title;
        this.author = author;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }


}
