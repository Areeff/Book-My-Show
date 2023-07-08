package com.example.Book.My.Show.Exceptions;

public class MovieDoesNotExists extends RuntimeException{
    public MovieDoesNotExists() {
        super("Movie does not exist with given id");
    }
}
