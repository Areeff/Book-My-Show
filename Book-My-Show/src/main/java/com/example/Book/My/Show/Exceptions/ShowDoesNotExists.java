package com.example.Book.My.Show.Exceptions;

public class ShowDoesNotExists extends RuntimeException {
    public ShowDoesNotExists() {
        super("Show does not exist with given id");
    }
}
