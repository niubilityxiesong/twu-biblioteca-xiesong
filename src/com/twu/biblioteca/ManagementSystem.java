package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void SystemIn() {
        helloPage();
        int inputNumber = mainMenu();
    }

    public void helloPage() {
        System.out.println("Welcome to library management system");
    }

    public int mainMenu() {
        Scanner inputSelection = new Scanner(System.in);
        System.out.println("Please choose a number:");
        System.out.println("1. Books List");
        System.out.println("2. CheckOut Book");
        System.out.println("3. Return Book");
        System.out.println("0. Exit System");
        int selection = inputSelection.nextInt();
        return selection;
    }

    public void gateway(int inputNumber) {
        switch (inputNumber) {
            case 1:
                showList();
            case 2:
                checkOutBook();
            case 3:
                returnBook();
            case 0:
                return;
        }
    }
}
