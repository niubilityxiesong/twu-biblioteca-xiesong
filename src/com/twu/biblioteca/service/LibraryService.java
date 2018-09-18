package com.twu.biblioteca.service;

import com.twu.biblioteca.display.DisplayMessage;
import com.twu.biblioteca.entity.Library;

public class LibraryService {

    public static void checkOut(Library library) {
        String[] s = library.getClass().getName().split("\\.");
        if (library.getNumber() > 0) {
            library.setNumber(0);
            DisplayMessage.checkOutSuccessMessage(s[s.length - 1]);
        } else {
            DisplayMessage.checkOutFailMessage(s[s.length - 1]);
        }
    }
}
