package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.Book;

import java.util.List;
import java.util.Scanner;

public class BookService {

    public static void showBookList(List<Book> bookList) {
        System.out.println("id   name           details");
        for (Book book : bookList) {
            if (book.getNumber() > 0) {
                book.printObject(book);
                System.out.println();
            }
        }
    }

    public static void returnBook(List<Book> bookList) {
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
}
