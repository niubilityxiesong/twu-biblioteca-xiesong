package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Movie;

import java.util.List;

public class MovieService {

    public static void showMovieList(List<Movie> movieList) {
        System.out.println("id    name      director  year  level");
        for (Movie movie : movieList) {
            if (movie.getNumber() > 0) {
                movie.printObject(movie);
                System.out.print("    ");
                System.out.println(movie.getLevel());
            }
        }
    }
}
