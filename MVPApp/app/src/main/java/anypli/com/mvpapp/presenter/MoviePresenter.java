package anypli.com.mvpapp.presenter;

import anypli.com.mvpapp.contract.MovieContract;
import anypli.com.mvpapp.data.model.MovieResponse;
import anypli.com.mvpapp.data.repository.MovieRepository;
import anypli.com.mvpapp.data.repository.RepositoryListener;

/**
 * Created by macbook on 15/10/2017.
 */

public class MoviePresenter implements MovieContract.Presenter {

      MovieContract.View view;

    public MoviePresenter(MovieContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchData() {
        MovieRepository movieRepository = new MovieRepository();
        movieRepository.fetchData(getRepositoryListener());
    }

    private RepositoryListener getRepositoryListener() {
        return new RepositoryListener() {
            @Override
            public void onFetchComplete(Object data) {
                view.showData((MovieResponse) data);
            }

            @Override
            public void onFetchFail(FailType type) {

            }
        };
    }
}
