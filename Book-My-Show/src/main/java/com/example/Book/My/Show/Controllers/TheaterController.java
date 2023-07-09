package com.example.Book.My.Show.Controllers;

import com.example.Book.My.Show.Dtos.RequestDtos.TheaterEntryDto;
import com.example.Book.My.Show.Dtos.RequestDtos.TheaterSeatEntryDto;
import com.example.Book.My.Show.Models.Theater;
import com.example.Book.My.Show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        try {
            String result = theaterService.addTheater(theaterEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addTheaterSeat")
    public ResponseEntity<String> addTheaterSeat(@RequestBody TheaterSeatEntryDto entryDto) {
        try {
            String result = theaterService.addTheaterSeat(entryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/theatersHavingShowOnGivenTime")
    public List<Theater>theatersHavingShowOnGivenTime(@RequestParam LocalTime time){
        return theaterService.theatersHavingShowOnGivenTime(time);
    }
}
