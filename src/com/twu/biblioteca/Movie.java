package com.twu.biblioteca;

public class Movie extends Book{
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
}
