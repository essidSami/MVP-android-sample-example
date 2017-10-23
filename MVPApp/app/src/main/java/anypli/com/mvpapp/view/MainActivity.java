package anypli.com.mvpapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import anypli.com.mvpapp.R;
import anypli.com.mvpapp.adapter.MovieAdapter;
import anypli.com.mvpapp.contract.MovieContract;
import anypli.com.mvpapp.data.model.Movie;
import anypli.com.mvpapp.data.model.MovieResponse;
import anypli.com.mvpapp.presenter.MoviePresenter;

public class MainActivity extends AppCompatActivity implements MovieContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MovieContract.Presenter presenter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rc_movies);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        presenter = new MoviePresenter(this);
        presenter.fetchData();
    }
    @Override
    public void showData(MovieResponse movieResponse) {
        Log.i(TAG, movieResponse.toString());
        recyclerView.setAdapter(new MovieAdapter(movieResponse.getMovies() ,this));
    }
    public void showDetails(Movie movie){
        Intent intent = new Intent(this , DetailsActivity.class);
        intent.putExtra(DetailsActivity.KEY, movie);
        startActivity(intent);
    }
}