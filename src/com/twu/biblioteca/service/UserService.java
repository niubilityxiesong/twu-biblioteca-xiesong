package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.User;

import java.util.List;
import java.util.Scanner;

public class UserService {

    public static User getUser(List<User> userList) {
        User presentUser = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("please input your username:");
        String username = input.nextLine();
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                presentUser = user;
            }
        }
        if (presentUser.getName() == null) {
            System.out.println("username is valid!");
            presentUser = getUser(userList);
        } else {
            System.out.println("Please input your password");
            if (presentUser.getPassword().equals(input.nextLine())) {
                return presentUser;
            } else {
                System.out.println("password is valid!");
                presentUser = getUser(userList);
            }
        }
        return presentUser;
    }

    public static void checkUserMessage(User presentUser) {
        System.out.println("name    email            phoneNumber");
        System.out.print(presentUser.getName());
        System.out.print("    ");
        System.out.print(presentUser.getEmail());
        System.out.print("    ");
        System.out.print(presentUser.getPhoneNumber());
        System.out.println();
    }
}
