package com.example.androidexam.Repository;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidexam.BookResponse;
import com.example.androidexam.Model.BookModel;

import Interfaces.BookAPI_Interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    // will return it in singleton
    private static BookRepository instance;

    // this variable has to be observed and changable from the api
    private MutableLiveData< BookModel > book;

    private BookRepository() {
        book = new MutableLiveData<>(); // we get new books all the time
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public LiveData< BookModel > getBook() {
        return book;
    }

    //Using the ServiceGenerator to create the API.
    //Respond in callback while HTTP-response code is checked.
    public void requestBook(String title) {
        BookAPI_Interface bookApi = Book_ServiceGenerator.getBookApi();
        Call< BookResponse > call = bookApi.getBook(title);
        call.enqueue(new Callback< BookResponse >() {
            @Override
            public void onResponse(Call< BookResponse > call, Response< BookResponse > response) {
                if (response.code() == 200) {
                    book.setValue(response.body().getBook());
                }
            }

            @Override
            public void onFailure(Call< BookResponse > call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
