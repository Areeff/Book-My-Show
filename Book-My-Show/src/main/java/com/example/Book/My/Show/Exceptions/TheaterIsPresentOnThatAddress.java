package com.example.Book.My.Show.Exceptions;

public class TheaterIsPresentOnThatAddress extends RuntimeException {
    public TheaterIsPresentOnThatAddress() {

        super("Theater is present on given address");
    }
}
