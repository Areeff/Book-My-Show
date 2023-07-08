package com.example.Book.My.Show.Exceptions;

public class UserAlreadyExistsWithEmail extends RuntimeException {
    public UserAlreadyExistsWithEmail() {
        super("User already exist with given email id");
    }
}
