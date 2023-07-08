package com.example.Book.My.Show.Dtos.RequestDtos;

import com.example.Book.My.Show.Enums.Genre;
import com.example.Book.My.Show.Enums.Language;
import lombok.Data;

import java.sql.Date;

@Data
public class MovieEntryDto {

    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
