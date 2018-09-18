package com.twu.biblioteca.service;

import com.twu.biblioteca.display.DisplayMessage;
import com.twu.biblioteca.entity.LibraryEntity;

public class LibraryEntityService {

    public static void checkOut(LibraryEntity libraryEntity) {
        String[] s = libraryEntity.getClass().getName().split("\\.");
        if (libraryEntity.getNumber() > 0) {
            libraryEntity.setNumber(0);
            DisplayMessage.checkOutSuccessMessage(s[s.length - 1]);
        } else {
            DisplayMessage.checkOutFailMessage(s[s.length - 1]);
        }
    }
}
