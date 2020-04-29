package Interfaces;

import com.example.androidexam.BookResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookAPI_Interface {

    @GET("books/v1/volumes?q= {search}")
    Call< BookResponse > getBook(@Path("search") String search);
}
