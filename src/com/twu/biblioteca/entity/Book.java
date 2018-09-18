package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.List;

public class Book extends LibraryEntity{
    public Book(int id, String name, String author, String date, int number) {
        super(id, name, author, date, number);
    }

    public static List<Book> initBook() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"西游记", "吴承恩", "2018-09", 1));
        bookList.add(new Book(2,"红楼梦", "曹雪芹", "2017-09", 1));
        bookList.add(new Book(3,"水浒传", "施耐庵", "2016-09", 1));
        bookList.add(new Book(4,"三国演义", "罗贯中", "2015-09", 1));
        return bookList;
    }
}
