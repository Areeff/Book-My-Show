package com.example.Book.My.Show.Repositories;

import com.example.Book.My.Show.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
