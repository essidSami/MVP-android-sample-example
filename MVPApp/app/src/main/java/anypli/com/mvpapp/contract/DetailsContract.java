package anypli.com.mvpapp.contract;

import android.os.Bundle;
import android.support.annotation.NonNull;

import anypli.com.mvpapp.data.model.Movie;

/**
 * Created by macbook on 17/10/2017.
 */

public class DetailsContract {

    public interface View{
        void showData(@NonNull Movie movie);
    }

    public interface Presenter{
        void onCreate(@NonNull Bundle bundle);
    }

}
