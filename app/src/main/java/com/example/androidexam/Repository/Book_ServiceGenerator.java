package com.example.androidexam.Repository;

import Interfaces.Google_BookSearchService_interface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Book_ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/volumes?q={search}")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static Google_BookSearchService_interface bookApi = retrofit.create(Google_BookSearchService_interface.class);

    public static Google_BookSearchService_interface getBookApi() {
        return bookApi;
    }
}