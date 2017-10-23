package anypli.com.mvpapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import anypli.com.mvpapp.R;
import anypli.com.mvpapp.adapter.holder.MovieHolder;
import anypli.com.mvpapp.data.model.Movie;
import anypli.com.mvpapp.view.MainActivity;

/**
 * Created by macbook on 15/10/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    private List<Movie> movies;
    private MainActivity mainActivity;

    public MovieAdapter(List<Movie> movies, MainActivity context) {
        this.movies = movies;
        this.mainActivity = context;
        notifyDataSetChanged();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_movie, parent, false);
        return new MovieHolder(view, mainActivity);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, final int position) {
        holder.setImageViewRow(movies.get(position).getImage());
        holder.setRatingRowBarMovie((float) movies.get(position).getRating());
        holder.setTextViewRowName(movies.get(position).getMovie());
        if (movies.size()-1 == position){
            holder.setVisibility();
        }

        holder.onClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.showDetails(movies.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
