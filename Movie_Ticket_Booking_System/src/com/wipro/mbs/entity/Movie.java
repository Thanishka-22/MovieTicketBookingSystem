package com.wipro.mbs.entity;

public class Movie {
    private String movieId;
    private String title;

    public Movie(String movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }

    public String getMovieId() {
        return movieId;
    }
}
