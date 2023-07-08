package com.example.Book.My.Show.Exceptions;

public class TheaterDoesNotExists extends RuntimeException {
    public TheaterDoesNotExists() {
        super("Theater does not exist with given id");
    }
}
