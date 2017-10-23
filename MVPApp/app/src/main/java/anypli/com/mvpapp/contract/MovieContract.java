package anypli.com.mvpapp.contract;

import anypli.com.mvpapp.data.model.MovieResponse;

/**
 * Created by macbook on 15/10/2017.
 */

public class MovieContract {

    public interface View {
        void showData(MovieResponse movieResponse);
    }

    public interface Presenter{
        void fetchData();
    }

}
