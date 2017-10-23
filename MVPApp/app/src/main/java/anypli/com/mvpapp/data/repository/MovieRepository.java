package anypli.com.mvpapp.data.repository;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import anypli.com.mvpapp.BuildConfig;
import anypli.com.mvpapp.api.ApiClient;
import anypli.com.mvpapp.data.model.MovieResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macbook on 15/10/2017.
 */

public class MovieRepository {

    private static final String TAG = MovieRepository.class.getSimpleName();

    MovieResponse movieResponse = new MovieResponse();

    RepositoryListener mRepositoryListener;

    public MovieResponse fetchData(RepositoryListener repositoryListener) {

        mRepositoryListener = repositoryListener;

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(10, TimeUnit.SECONDS);
        httpClient.readTimeout(15, TimeUnit.SECONDS);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL).addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        ApiClient api = retrofit.create(ApiClient.class);

        Call<MovieResponse> jsonObjectCall = api.getData();

        jsonObjectCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.i(TAG, response.body().toString());
                mRepositoryListener.onFetchComplete(response.body());

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                mRepositoryListener.onFetchFail(RepositoryListener.FailType.SERVER);
                t.printStackTrace();

            }
        });
        return movieResponse;

    }

}
