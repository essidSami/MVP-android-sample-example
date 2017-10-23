package anypli.com.mvpapp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import anypli.com.mvpapp.contract.DetailsContract;
import anypli.com.mvpapp.data.model.Movie;
import anypli.com.mvpapp.view.DetailsActivity;

/**
 * Created by macbook on 17/10/2017.
 */

public class DetailsPresenter implements DetailsContract.Presenter {

    private DetailsContract.View mView;

    public DetailsPresenter(DetailsContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void onCreate(@NonNull Bundle bundle) {
        Movie movie = (Movie) bundle.get(DetailsActivity.KEY);
        if (movie != null){
            mView.showData(movie);
        }
    }

}

