package com.twu.biblioteca;

import com.twu.biblioteca.display.DisplayMessage;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.LibraryEntity;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.LibraryEntityService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;

import java.util.List;
import java.util.Scanner;

public class ManagementSystem {
    private List<Book> bookList;
    private List<Movie> movieList;
    private List<User> userList;
    private User presentUser;
    private DisplayMessage menu;

    public ManagementSystem() {
        this.bookList = Book.initBook();
        this.movieList = Movie.initMovie();
        this.userList = User.initUser();
        this.menu = DisplayMessage.initMenu();
    }

    public User getPresentUser() {
        return presentUser;
    }

    public void setPresentUser(User presentUser) {
        this.presentUser = presentUser;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void systemIn() {
        int inputNumber = mainMenu();
        gateway(inputNumber);
    }

    public void login() {
        presentUser = UserService.getUser(userList);
        systemIn();
    }

    public int mainMenu() {
        Scanner inputSelection = new Scanner(System.in);
        int selection = 0;

        menu.displayMenu();
        if (inputSelection.hasNextInt()) {
            selection = inputSelection.nextInt();
        } else {
            DisplayMessage.notNumberMessage();
            systemIn();
        }
        return selection;
    }

    public void gateway(int inputNumber) {
        switch (inputNumber) {
            case 1:
                BookService.showBookList(bookList);
                systemIn();
                break;
            case 2:
                Scanner inputSelection = new Scanner(System.in);
                DisplayMessage.ChooseIdMessage("book");
                int selection = inputSelection.nextInt() - 1;
                Book selectedBook = bookList.get(selection);
                LibraryEntityService.checkOut(selectedBook);
                systemIn();
                break;
            case 3:
                BookService.returnBook(bookList);
                systemIn();
                break;
            case 4:
                MovieService.showMovieList(movieList);
                systemIn();
                break;
            case 5:
                Scanner input = new Scanner(System.in);
                DisplayMessage.ChooseIdMessage("movie");
                int index = input.nextInt() - 1;
                LibraryEntity selectedMovie = movieList.get(index);
                LibraryEntityService.checkOut(selectedMovie);
                systemIn();
                break;
            case 6:
                UserService.checkUserMessage(presentUser);
                systemIn();
                break;
            case 0:
                break;
            default:
                DisplayMessage.validInputMessage();
                systemIn();
        }
    }
}
