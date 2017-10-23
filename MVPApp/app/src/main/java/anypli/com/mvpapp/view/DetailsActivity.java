package anypli.com.mvpapp.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import anypli.com.mvpapp.R;
import anypli.com.mvpapp.contract.DetailsContract;
import anypli.com.mvpapp.data.model.Movie;
import anypli.com.mvpapp.presenter.DetailsPresenter;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {

    public static final String KEY = "key";
    private static final String TAG = DetailsActivity.class.getSimpleName();
    private DetailsContract.Presenter mPresenter;

    private ImageView imageViewMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageViewMovie = (ImageView) findViewById(R.id.imageViewMovie);
        mPresenter = new DetailsPresenter(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            mPresenter.onCreate(bundle);
        }
    }

    @Override
    public void showData(Movie movie) {

        Glide.with(getApplicationContext())
                .load(movie.getImage())
                .placeholder(ContextCompat.getDrawable(getApplicationContext(), R.drawable.place_holder))
                .into(imageViewMovie);



    }

}
