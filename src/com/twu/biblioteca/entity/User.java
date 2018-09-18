package com.twu.biblioteca.entity;

import com.twu.biblioteca.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private long phoneNumber;
    private String username;
    private String password;
    private UserService userService;

    public User(String name, String email, long phoneNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.userService = new UserService();
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<User> initUser() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("张三", "123456@qq.com", 123456789013L, "010-1234", "123456"));
        userList.add(new User("李四", "345678@qq.com", 975456723613L, "011-1235", "654321"));
        return userList;
    }


}
