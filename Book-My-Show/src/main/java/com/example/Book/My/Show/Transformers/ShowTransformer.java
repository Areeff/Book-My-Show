package com.example.Book.My.Show.Transformers;

import com.example.Book.My.Show.Dtos.RequestDtos.ShowEntryDto;
import com.example.Book.My.Show.Models.Show;

public class ShowTransformer {

    public static Show showDtoToShow(ShowEntryDto showEntryDto) {
        Show show = Show.builder()
                .time(showEntryDto.getShowStartTime())
                .date(showEntryDto.getShowDate())
                .build();

        return show;
    }
}
