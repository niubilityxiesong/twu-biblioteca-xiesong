package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ManagementSystemTest {

    @Test
    public void helloPage() {
        //given
        ManagementSystem managementSystem = new ManagementSystem();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        //when
        managementSystem.helloPage();
        //then
        assertThat(output.toString(), is("Welcome to library management system\n"));
    }
}