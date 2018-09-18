package com.twu.biblioteca.entity;

public abstract class Library {
    private int id;
    private String name;
    private String author;
    private String date;
    private int number;

    public Library(int id, String name, String author, String date, int number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.date = date;
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

    public void printObject(Library library) {
        System.out.print(library.getId());
        System.out.print("    ");
        System.out.print(library.getName());
        System.out.print("      ");
        System.out.print(library.getAuthor());
        System.out.print("  ");
        System.out.print(library.getDate());
    }
}
