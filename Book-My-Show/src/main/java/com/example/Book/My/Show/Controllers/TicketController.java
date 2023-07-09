package com.example.Book.My.Show.Controllers;


import com.example.Book.My.Show.Dtos.RequestDtos.TicketDeleteDto;
import com.example.Book.My.Show.Dtos.RequestDtos.TicketEntryDto;
import com.example.Book.My.Show.Dtos.ResponseDtos.TicketResponseDto;
import com.example.Book.My.Show.Models.Ticket;
import com.example.Book.My.Show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<TicketResponseDto> ticketBooking(@RequestBody TicketEntryDto ticketEntryDto) {
        try {
            TicketResponseDto result = ticketService.ticketBooking(ticketEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/getAllBookedTicketsByUser")
    public ResponseEntity<List<Ticket>>getAllBookedTicketsByUser(@RequestParam Integer userId){
        try{
            List<Ticket>ticketList=ticketService.getAllBookedTicketsByUser(userId);
            return new ResponseEntity<>(ticketList,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTotalCollectionForMovie")
    public ResponseEntity<String>getTotalCollectionForMovie(@RequestParam Integer movieId){
        try {
            Integer totalCollection=ticketService.getTotalCollectionForMovie(movieId);
            return new ResponseEntity<>(totalCollection.toString(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rateMovie")
    public  ResponseEntity<String> rateMovie(@RequestParam Integer movieId){
        try {
            String response=ticketService.rateMovie(movieId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
