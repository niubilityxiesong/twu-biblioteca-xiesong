package com.twu.biblioteca.service;

import com.twu.biblioteca.display.DisplayMessage;
import com.twu.biblioteca.entity.User;

import java.util.List;
import java.util.Scanner;

public class UserService {

    public static User getUser(List<User> userList) {
        User presentUser = new User();
        Scanner input = new Scanner(System.in);
        DisplayMessage.inputUsernameMessage();
        String username = input.nextLine();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                presentUser = user;
            }
        }
        if (presentUser.getName() == null) {
            DisplayMessage.usernameValidMessage();
            presentUser = getUser(userList);
        } else {
            DisplayMessage.inputPasswordMessage();
            if (presentUser.getPassword().equals(input.nextLine())) {
                return presentUser;
            } else {
                DisplayMessage.passwordValidMessage();
                presentUser = getUser(userList);
            }
        }
        return presentUser;
    }

    public static void checkUserMessage(User presentUser) {
        DisplayMessage.userHeaderMessage();
        System.out.print(presentUser.getName());
        System.out.print("    ");
        System.out.print(presentUser.getEmail());
        System.out.print("    ");
        System.out.print(presentUser.getPhoneNumber());
        System.out.println();
    }
}
