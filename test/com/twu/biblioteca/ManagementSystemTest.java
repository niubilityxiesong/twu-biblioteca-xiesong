package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ManagementSystemTest {

    ManagementSystem managementSystem;

    @Before
    public void setUp() {
        managementSystem = new ManagementSystem();
    }

    @Test
    public void helloPage_should_return_welcome_message() {
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        managementSystem.helloPage();
        //then
        assertThat(output.toString(), is("Welcome to library management system\n"));
    }
}