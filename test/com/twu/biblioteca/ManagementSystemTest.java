package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ManagementSystemTest {

    ManagementSystem managementSystem;

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
        assertThat(output.toString(), is("Welcome to library management system\n"));
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
}