package anypli.com.mvpapp.adapter.holder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import anypli.com.mvpapp.R;

/**
 * Created by macbook on 15/10/2017.
 */

public class MovieHolder extends RecyclerView.ViewHolder {

    private Context context;

    private ImageView imageViewRow;
    private TextView textViewRowName;
    private TextView textViewRowTagLine;
    private TextView textViewRowYear;
    private TextView textViewRowDuration;
    private TextView textViewRowDirector;
    private TextView textViewRowCast;
    private TextView textViewRowStory;
    private RatingBar ratingRowBarMovie;
    private View view;
    private LinearLayout mLinearLayout;


    public MovieHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        imageViewRow = itemView.findViewById(R.id.imageViewRow);
        textViewRowName = itemView.findViewById(R.id.textViewRowName);
        textViewRowTagLine = itemView.findViewById(R.id.textViewRowTagLine);
        textViewRowYear = itemView.findViewById(R.id.textViewRowYear);
        textViewRowDuration = itemView.findViewById(R.id.textViewRowDuration);
        textViewRowDirector = itemView.findViewById(R.id.textViewRowDirector);
        textViewRowCast = itemView.findViewById(R.id.textViewRowCast);
        textViewRowStory = itemView.findViewById(R.id.textViewRowStory);
        ratingRowBarMovie = itemView.findViewById(R.id.ratingRowBarMovie);
        view = itemView.findViewById(R.id.separator);
        mLinearLayout = itemView.findViewById(R.id.container);
    }

    public ImageView getImageViewRow() {
        return imageViewRow;
    }

    public void setImageViewRow(String path) {
        Glide.with(context).load(path).placeholder(ContextCompat.getDrawable(context,R.drawable.place_holder)).into(imageViewRow);

    }

    public TextView getTextViewRowName() {
        return textViewRowName;
    }

    public void setTextViewRowName(String textViewRowName) {
        this.textViewRowName.setText(textViewRowName);
    }

    public TextView getTextViewRowTagLine() {
        return textViewRowTagLine;
    }

    public void setTextViewRowTagLine(String textViewRowTagLine) {
        this.textViewRowTagLine.setText(textViewRowTagLine);
    }

    public TextView getTextViewRowYear() {
        return textViewRowYear;
    }

    public void setTextViewRowYear(String textViewRowYear) {
        this.textViewRowYear.setText(textViewRowYear);
    }

    public TextView getTextViewRowDuration() {
        return textViewRowDuration;
    }

    public void setTextViewRowDuration(String textViewRowDuration) {
        this.textViewRowDuration.setText(textViewRowDuration);
    }

    public TextView getTextViewRowDirector() {
        return textViewRowDirector;
    }

    public void setTextViewRowDirector(String textViewRowDirector) {
        this.textViewRowDirector.setText(textViewRowDirector);
    }

    public TextView getTextViewRowCast() {
        return textViewRowCast;
    }

    public void setTextViewRowCast(String textViewRowCast) {
        this.textViewRowCast.setText(textViewRowCast);
    }

    public TextView getTextViewRowStory() {
        return textViewRowStory;
    }

    public void setTextViewRowStory(String textViewRowStory) {
        this.textViewRowStory.setText(textViewRowStory);
    }

    public RatingBar getRatingRowBarMovie() {
        return ratingRowBarMovie;
    }

    public void setRatingRowBarMovie(float ratingRowBarMovie) {
        this.ratingRowBarMovie.setRating(ratingRowBarMovie);
    }

    public void setVisibility() {
        this.view.setVisibility(View.GONE);
    }

    public void onClick(View.OnClickListener onClickListener){
        mLinearLayout.setOnClickListener(onClickListener);
    }
}
