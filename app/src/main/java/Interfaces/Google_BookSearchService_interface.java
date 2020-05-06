package Interfaces;

import com.example.androidexam.BookResponse;
import com.example.androidexam.Model.VolumeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Google_BookSearchService_interface {

    @GET("/books/v1/volumes")
    Call< VolumeResponse > searchVolumes( @Query("q") String query);

    Call< BookResponse> getBook(String title);
}
