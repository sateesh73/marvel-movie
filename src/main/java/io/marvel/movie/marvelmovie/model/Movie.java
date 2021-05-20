package io.marvel.movie.marvelmovie.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private Long id;
    private String title;
    private String genres;
    private LocalDate releaseDate;
    private String director;
    private String screenWriter;
    private String producer;
    private String cast;
    private String language;
    private String filmingLocations;
    private String status;
    private String movieRating;
    private String reviewRating;
    private String movieRunTime;
    private String budget;
    private String boxOffice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenWriter() {
        return screenWriter;
    }

    public void setScreenWriter(String screenWriter) {
        this.screenWriter = screenWriter;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFilmingLocations() {
        return filmingLocations;
    }

    public void setFilmingLocations(String filmingLocations) {
        this.filmingLocations = filmingLocations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getMovieRunTime() {
        return movieRunTime;
    }

    public void setMovieRunTime(String movieRunTime) {
        this.movieRunTime = movieRunTime;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

}
