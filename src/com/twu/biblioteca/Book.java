package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String date;
    private int number;

    public Book(String name, String author, String date, int number) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
