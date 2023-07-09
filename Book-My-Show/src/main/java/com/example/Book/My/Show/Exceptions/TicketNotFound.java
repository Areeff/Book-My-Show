package com.example.Book.My.Show.Exceptions;

public class TicketNotFound extends RuntimeException{
    public TicketNotFound() {
        super("Ticket not found");
    }
}
