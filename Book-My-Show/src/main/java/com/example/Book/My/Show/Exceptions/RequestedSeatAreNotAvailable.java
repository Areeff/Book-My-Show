package com.example.Book.My.Show.Exceptions;

public class RequestedSeatAreNotAvailable extends RuntimeException{
    public RequestedSeatAreNotAvailable() {
        super("requested seats are already booked");
    }
}
