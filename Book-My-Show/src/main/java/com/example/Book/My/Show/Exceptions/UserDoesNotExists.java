package com.example.Book.My.Show.Exceptions;

public class UserDoesNotExists extends RuntimeException{
    public UserDoesNotExists() {
        super("user not found");
    }
}
