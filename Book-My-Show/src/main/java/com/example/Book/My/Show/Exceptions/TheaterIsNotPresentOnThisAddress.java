package com.example.Book.My.Show.Exceptions;

public class TheaterIsNotPresentOnThisAddress extends RuntimeException {
    public TheaterIsNotPresentOnThisAddress() {
        super("Theater is not present on given address");
    }
}
