package com.example.BookMyShow.models;

public class Movie {
    int movieId;
    String movieName;
    int movieDurationInMinutes;

    public Movie(int id, String movieName, int movieDurationInMinutes){
        this.movieId = id;
        this.movieName = movieName;
        this.movieDurationInMinutes = movieDurationInMinutes;
    }

    public int getMovieId(){
        return movieId;
    }

    public void setMovieId(int movieId){
        this.movieId = movieId;
    }

    public String getMovieName(){
        return movieName;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    public int getMovieDuration(){
        return movieDurationInMinutes;
    }

    public void setMovieDuration(int movieDuration){
        this.movieDurationInMinutes = movieDuration;
    }
}
