package com.twu.biblioteca;

import com.twu.biblioteca.display.DisplayMessage;

public class BibliotecaApp {

    public static void main(String[] args) {
        ManagementSystem managementSystem = new ManagementSystem();
        DisplayMessage.welcomeMessage();
        managementSystem.login();
    }
}
