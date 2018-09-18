package com.twu.biblioteca.display;

import java.util.ArrayList;
import java.util.List;

public class ShowMenu {
    private List<String> menuList;

    public ShowMenu() {
        menuList = new ArrayList<>();
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }

    public void addMenu(String name) {
        this.menuList.add(name);
    }

    public void displayMenu() {
        System.out.println("Please choose a number:");
        this.menuList.forEach(System.out::println);
    }

    public static ShowMenu initMenu() {
        ShowMenu showMenu = new ShowMenu();
        showMenu.menuList.add("1. Books List");
        showMenu.menuList.add("2. CheckOut Book");
        showMenu.menuList.add("3. Return Book");
        showMenu.menuList.add("4. Movies List");
        showMenu.menuList.add("5. CheckOut Movie");
        showMenu.menuList.add("6. Check User Message");
        showMenu.menuList.add("0. Exit System");
        return showMenu;
    }
}
