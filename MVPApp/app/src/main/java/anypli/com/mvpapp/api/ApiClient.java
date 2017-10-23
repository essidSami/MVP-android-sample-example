package anypli.com.mvpapp.api;

import anypli.com.mvpapp.data.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by macbook on 15/10/2017.
 */

public interface ApiClient {

    @GET("moviesData.txt")
    Call<MovieResponse> getData();
}
