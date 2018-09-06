package com.twu.biblioteca;

public class Movie {
    private int id;
    private String name;
    private String date;
    private String director;
    private String level;
    private int number;

    public Movie(int id, String name, String date, String director, String level, int number) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.director = director;
        this.level = level;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
