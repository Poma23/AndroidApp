package com.example.androidexam.Repository;

import Interfaces.BookAPI_Interface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Book_ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/volumes?q={search}")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static BookAPI_Interface bookApi = retrofit.create(BookAPI_Interface.class);

    public static BookAPI_Interface getBookApi() {
        return bookApi;
    }
}