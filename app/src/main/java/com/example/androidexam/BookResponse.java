package com.example.androidexam;

import com.example.androidexam.Model.BookModel;

public class BookResponse {

    private VolumeInfo volumeInfo;
    private Items items;

    public BookModel getBook(){
        return new BookModel(volumeInfo.title, volumeInfo.author, volumeInfo.language);
    }

    private class Items {
        private String VolumeInfo;
    }

    private class VolumeInfo{
        private String title;
        private String author;
        private String language;
    }


}
