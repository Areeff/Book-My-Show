package com.example.Book.My.Show.Transformers;

import com.example.Book.My.Show.Dtos.ResponseDtos.TicketResponseDto;
import com.example.Book.My.Show.Models.Show;
import com.example.Book.My.Show.Models.Ticket;

public class TicketTransformer {

    public static TicketResponseDto returnTicket(Show show, Ticket ticket) {
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
