package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementSystem {
    private List<Book> bookList = new ArrayList<Book>();

    public ManagementSystem() {
        Book book1 = new Book(1,"西游记", "吴承恩", "2018-09", 1);
        this.bookList.add(book1);
        Book book2 = new Book(2,"红楼梦", "曹雪芹", "2017-09", 1);
        this.bookList.add(book2);
        Book book3 = new Book(3,"水浒传", "施耐庵", "2016-09", 1);
        this.bookList.add(book3);
        Book book4 = new Book(4,"三国演义", "罗贯中", "2015-09", 1);
        this.bookList.add(book4);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void systemIn() {
        int inputNumber = mainMenu();
        gateway(inputNumber);
    }

    public void helloPage() {
        System.out.println("Welcome to library management system!");
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
                systemIn();
                break;
            case 2:
                checkOutBook();
                systemIn();
                break;
            case 3:
                returnBook();
                systemIn();
                break;
            case 0:
                break;
            default:
                System.out.println("Select a valid option!");
                systemIn();
        }
    }

    private void returnBook() {
        boolean mark = true;
        Scanner inputSelection = new Scanner(System.in);
        System.out.println("please write the book name:");
        final String bookName = inputSelection.nextLine();
        for (Book book : bookList) {
            if (book.getName().equals(bookName)) {
                book.setNumber(1);
                mark = false;
                System.out.println("Thank you for returning the book.");
            }
        }
        if (mark) {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void checkOutBook() {
        Scanner inputSelection = new Scanner(System.in);
        System.out.println("please choose a book id:");
        int selection = inputSelection.nextInt() - 1;
        Book selectedBook = bookList.get(selection);
        if (selectedBook.getNumber() > 0) {
            selectedBook.setNumber(0);
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available");
        }
    }

    public void showList() {
        System.out.println("id   name           details");
        for (Book book : bookList) {
            if (book.getNumber() > 0) {
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
    }
}
