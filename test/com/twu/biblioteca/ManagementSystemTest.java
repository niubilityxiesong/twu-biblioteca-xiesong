package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ManagementSystemTest {

    private ManagementSystem managementSystem;

    @Before
    public void setUp() {
        managementSystem = new ManagementSystem();
    }

    @Test
    public void helloPage_should_return_welcome_message() {
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        managementSystem.helloPage();
        //then
        assertThat(output.toString(), is("Welcome to library management system!\n"));
    }

    @Test
    public void showList_should_return_not_borrow_book() {
        //given
        List<Book> bookList = managementSystem.getBookList();
        bookList.get(1).setNumber(0);
        bookList.get(2).setNumber(0);
        bookList.get(3).setNumber(0);
        managementSystem.setBookList(bookList);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expect = "id   name           details\n";
        expect += "1    西游记      吴承恩  2018-09\n";
        //when
        managementSystem.showList();
        //then
        assertThat(output.toString(), is(expect));
    }

    @Test
    public void mainMenu_should_return_input_number() {
        //given
        String data = "1";
        //when
        int input;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            input = managementSystem.mainMenu();
        } finally {
            System.setIn(stdin);
        }
        //then
        assertThat(input, is(1));
    }

    @Test
    public void checkOutBook_should_return_success_message() {
        //given
        String data = "1";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            managementSystem.checkOutBook();
        } finally {
            System.setIn(stdin);
        }
        //then
        assertThat(output.toString(), is("please choose a book id:\nThank you! Enjoy the book\n"));
    }

    @Test
    public void returnBook_should_return_success_message() {
        //given
        String data = "红楼梦";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        List<Book> bookList = managementSystem.getBookList();
        bookList.get(0).setNumber(0);
        managementSystem.setBookList(bookList);
        //when
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            managementSystem.returnBook();
        } finally {
            System.setIn(stdin);
        }
        //then
        assertThat(output.toString(), is("please write the book name:\nThank you for returning the book.\n"));
    }
}