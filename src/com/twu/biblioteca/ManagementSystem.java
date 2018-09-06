package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementSystem {
    private List<Book> bookList = new ArrayList<Book>();
    private List<Movie> movieList = new ArrayList<Movie>();
    private List<User> userList = new ArrayList<User>();

    public ManagementSystem() {
        Book book1 = new Book(1,"西游记", "吴承恩", "2018-09", 1);
        this.bookList.add(book1);
        Book book2 = new Book(2,"红楼梦", "曹雪芹", "2017-09", 1);
        this.bookList.add(book2);
        Book book3 = new Book(3,"水浒传", "施耐庵", "2016-09", 1);
        this.bookList.add(book3);
        Book book4 = new Book(4,"三国演义", "罗贯中", "2015-09", 1);
        this.bookList.add(book4);

        Movie movie1 = new Movie(1, "哈利波特1", "JK", "2000-01", 1, "10");
        this.movieList.add(movie1);
        Movie movie2 = new Movie(2, "哈利波特2", "JK", "2001-01", 1, "9");
        this.movieList.add(movie2);
        Movie movie3 = new Movie(3, "哈利波特3", "JK", "2002-01", 1, "8");
        this.movieList.add(movie3);
        Movie movie4 = new Movie(4, "哈利波特4", "JK", "2003-01", 1, "未评级");
        this.movieList.add(movie4);

        User user1 = new User("张三", "123456@qq.com", 123456789013L, "010-1234", "123456");
        this.userList.add(user1);
        User user2 = new User("李四", "345678@qq.com", 975456723613L, "011-1235", "654321");
        this.userList.add(user2);
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

    public void helloPage() {
        System.out.println("Welcome to library management system!");
    }

    public int mainMenu() {
        Scanner inputSelection = new Scanner(System.in);
        System.out.println("Please choose a number:");
        System.out.println("1. Books List");
        System.out.println("2. CheckOut Book");
        System.out.println("3. Return Book");
        System.out.println("4. Movies List");
        System.out.println("0. Exit System");
        int selection = inputSelection.nextInt();
        return selection;
    }

    public void gateway(int inputNumber) {
        switch (inputNumber) {
            case 1:
                showBookList();
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
            case 4:
                showMovieList();
                systemIn();
                break;
            case 0:
                break;
            default:
                System.out.println("Select a valid option!");
                systemIn();
        }
    }

    public void showMovieList() {
        System.out.println("id    name    year    director    level");
        for (Movie movie : movieList) {
            if (movie.getNumber() > 0) {
                movie.printObject(movie);
                System.out.print("  ");
                System.out.println(movie.level);
            }
        }
    }

    public void returnBook() {
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

    public void showBookList() {
        System.out.println("id   name           details");
        for (Book book : bookList) {
            if (book.getNumber() > 0) {
                book.printObject(book);
                System.out.println();
            }
        }
    }
}
