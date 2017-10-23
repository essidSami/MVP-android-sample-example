package anypli.com.mvpapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 15/10/2017.
 */

public class Movie implements Parcelable {

    @SerializedName("movie")
    private String movie;

    @SerializedName("year")
    private Integer year;

    @SerializedName("rating")
    private double rating;

    @SerializedName("duration")
    private String duration;

    @SerializedName("director")
    private String director;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("cast")
    private List<Cast> cast = new ArrayList<>();

    @SerializedName("image")
    private String image;

    @SerializedName("story")
    private String story;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public List<Cast> getCast() {
        if (cast != null) {
            return cast;
        } else {
            return new ArrayList<>();
        }
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public String getImage() {
        if (image != null){
            return image;
        }else {
            return "http://";
        }
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie='" + movie + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", duration='" + duration + '\'' +
                ", director='" + director + '\'' +
                ", tagline='" + tagline + '\'' +
                ", cast=" + cast +
                ", image='" + image + '\'' +
                ", story='" + story + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movie);
        dest.writeValue(this.year);
        dest.writeDouble(this.rating);
        dest.writeString(this.duration);
        dest.writeString(this.director);
        dest.writeString(this.tagline);
        dest.writeList(this.cast);
        dest.writeString(this.image);
        dest.writeString(this.story);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.movie = in.readString();
        this.year = (Integer) in.readValue(Integer.class.getClassLoader());
        this.rating = in.readDouble();
        this.duration = in.readString();
        this.director = in.readString();
        this.tagline = in.readString();
        this.cast = new ArrayList<Cast>();
        in.readList(this.cast, Cast.class.getClassLoader());
        this.image = in.readString();
        this.story = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}