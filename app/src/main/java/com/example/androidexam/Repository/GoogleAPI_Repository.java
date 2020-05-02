package com.example.androidexam.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidexam.Model.VolumeResponse;

import Interfaces.Google_BookSearchService_interface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoogleAPI_Repository {

    private static final String BOOK_SEARCH_SERVICE_BASE_URL = "https://www.googleapis.com/";

    private Google_BookSearchService_interface bookSearchService;
    private MutableLiveData< VolumeResponse > volumesResponseLiveData;

    //interaction with the remote data source (Google Books API) using Retrofit2
    public GoogleAPI_Repository() {
        volumesResponseLiveData = new MutableLiveData<>(); // they have to be changable

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        bookSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Google_BookSearchService_interface.class);

    }

    public void searchVolumes(String keyword) {
        bookSearchService.searchVolumes(keyword)
                .enqueue(new Callback< VolumeResponse >() {
                    @Override
                    public void onResponse(Call< VolumeResponse > call, Response< VolumeResponse > response) {
                        if (response.body() != null) {
                            volumesResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call< VolumeResponse > call, Throwable t) {
                        volumesResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData< VolumeResponse > getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
