package com.twu.biblioteca.display;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessage {
    private List<String> menuList;

    public DisplayMessage() {
        menuList = new ArrayList<>();
    }

    public static void notNumberMessage() {
        System.out.println("Please input right number");
    }

    public static void ChooseIdMessage(String name) {
        System.out.println("please choose a " + name + " id:");
    }

    public static void validInputMessage() {
        System.out.println("Select a valid option!");
    }

    public static void checkOutSuccessMessage(String name) {
        System.out.println("Thank you! Enjoy the " + name);
    }

    public static void checkOutFailMessage(String name) {
        System.out.println("That " + name + " is not available");
    }

    public static void MovieHeaderMessage() {
        System.out.println("id    name      director  year  level");
    }

    public static void BookHeaderMessage() {
        System.out.println("id   name           details");
    }

    public static void returnBookNameMessage() {
        System.out.println("please write the book name:");
    }

    public static void returnBookSuccessMessage() {
        System.out.println("Thank you for returning the book.");
    }

    public static void returnBookFailMessage() {
        System.out.println("That is not a valid book to return.");
    }

    public static void inputUsernameMessage() {
        System.out.println("please input your username:");
    }

    public static void usernameValidMessage() {
        System.out.println("username is valid!");
    }

    public static void inputPasswordMessage() {
        System.out.println("Please input your password");
    }

    public static void passwordValidMessage() {
        System.out.println("password is valid!");
    }

    public static void userHeaderMessage() {
        System.out.println("name    email            phoneNumber");
    }

    public void displayMenu() {
        System.out.println("Please choose a number:");
        this.menuList.forEach(System.out::println);
    }

    public static DisplayMessage initMenu() {
        DisplayMessage displayMessage = new DisplayMessage();
        displayMessage.menuList.add("1. Books List");
        displayMessage.menuList.add("2. CheckOut Book");
        displayMessage.menuList.add("3. Return Book");
        displayMessage.menuList.add("4. Movies List");
        displayMessage.menuList.add("5. CheckOut Movie");
        displayMessage.menuList.add("6. Check User Message");
        displayMessage.menuList.add("0. Exit System");
        return displayMessage;
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to library management system!");
    }


}
