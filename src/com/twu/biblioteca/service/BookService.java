package com.twu.biblioteca.service;

import com.twu.biblioteca.display.DisplayMessage;
import com.twu.biblioteca.entity.Book;

import java.util.List;
import java.util.Scanner;

public class BookService {

    public static void showBookList(List<Book> bookList) {
        DisplayMessage.BookHeaderMessage();
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
        DisplayMessage.returnBookNameMessage();
        final String bookName = inputSelection.nextLine();
        for (Book book : bookList) {
            if (book.getName().equals(bookName)) {
                book.setNumber(1);
                mark = false;
                DisplayMessage.returnBookSuccessMessage();
            }
        }
        if (mark) {
            DisplayMessage.returnBookFailMessage();
        }
    }
}
