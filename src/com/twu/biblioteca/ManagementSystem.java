package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {
    private List<Book> bookList = new ArrayList<Book>();

    public ManagementSystem() {
        Book book1 = new Book("西游记", "吴承恩", "2018-09", 1);
        this.bookList.add(book1);
        Book book2 = new Book("红楼梦", "曹雪芹", "2017-09", 1);
        this.bookList.add(book2);
        Book book3 = new Book("水浒传", "施耐庵", "2016-09", 1);
        this.bookList.add(book3);
        Book book4 = new Book("三国演义", "罗贯中", "2015-09", 1);
        this.bookList.add(book4);
    }

    public void helloPage() {
        System.out.println("Welcome to library management system");
    }
}
