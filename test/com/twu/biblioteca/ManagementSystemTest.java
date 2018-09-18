package com.twu.biblioteca;

import com.twu.biblioteca.display.DisplayMessage;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.LibraryEntity;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
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
        DisplayMessage.welcomeMessage();
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
        BookService.showBookList(managementSystem.getBookList());
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
    public void checkOut_book_should_return_success_message() {
        //given
        List<Book> bookList = managementSystem.getBookList();
        Book book = bookList.get(0);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        LibraryEntity.checkOut(book);
        //then
        assertThat(output.toString(), is("Thank you! Enjoy the Book\n"));
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
            BookService.returnBook(managementSystem.getBookList());
        } finally {
            System.setIn(stdin);
        }
        //then
        assertThat(output.toString(), is("please write the book name:\nThank you for returning the book.\n"));
    }

    @Test
    public void showMovieList_should_return_all_movies_without_borrow() {
        //given
        List<Movie> movieList = managementSystem.getMovieList();
        movieList.get(0).setNumber(0);
        movieList.get(1).setNumber(0);
        movieList.get(2).setNumber(0);
        managementSystem.setMovieList(movieList);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        MovieService.showMovieList(managementSystem.getMovieList());
        //then
        assertThat(output.toString(), is("id    name      director  year  level\n4    哈利波特4      JK  2003-01    未评级\n"));
    }

    @Test
    public void checkOut_movie_should_return_success_message() {
        //given
        List<Movie> movieList = managementSystem.getMovieList();
        Movie movie = movieList.get(0);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        LibraryEntity.checkOut(movie);
        //then
        assertThat(output.toString(), is("Thank you! Enjoy the Movie\n"));
    }

    @Test
    public void checkUserMessage_should_return_present_user_message() {
        //given
        managementSystem.setPresentUser(managementSystem.getUserList().get(0));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        UserService.checkUserMessage(managementSystem.getPresentUser());
        //then
        assertThat(output.toString(), is("name    email            phoneNumber\n张三    123456@qq.com    123456789013\n"));
    }
}