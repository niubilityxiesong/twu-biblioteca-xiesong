package com.twu.biblioteca;

public class Book {
    private int id;
    private String name;
    private String author;
    private String date;
    private int number;

    public Book(int id, String name, String author, String date, int number) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printBook(Book book) {
        System.out.print(book.getId());
        System.out.print("    ");
        System.out.print(book.getName());
        System.out.print("      ");
        System.out.print(book.getAuthor());
        System.out.print("  ");
        System.out.print(book.getDate());
        System.out.println();
    }
}
