package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.List;

public class Movie extends Library {
    String level;

    public Movie(int id, String name, String author, String date, int number, String level) {
        super(id, name, author, date, number);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static List<Movie> initMovie() {
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie(1, "哈利波特1", "JK", "2000-01", 1, "10"));
        movieList.add(new Movie(2, "哈利波特2", "JK", "2001-01", 1, "9"));
        movieList.add(new Movie(3, "哈利波特3", "JK", "2002-01", 1, "8"));
        movieList.add(new Movie(4, "哈利波特4", "JK", "2003-01", 1, "未评级"));
        return movieList;
    }
}
