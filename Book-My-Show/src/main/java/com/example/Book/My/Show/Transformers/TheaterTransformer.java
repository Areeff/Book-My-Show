package com.example.Book.My.Show.Transformers;

import com.example.Book.My.Show.Dtos.RequestDtos.TheaterEntryDto;
import com.example.Book.My.Show.Models.Theater;

public class TheaterTransformer {

    public static Theater theaterDtoToTheater(TheaterEntryDto entryDto) {
        Theater theater = Theater.builder()
                .name(entryDto.getName())
                .address(entryDto.getAddress())
                .build();
        return theater;
    }
}
