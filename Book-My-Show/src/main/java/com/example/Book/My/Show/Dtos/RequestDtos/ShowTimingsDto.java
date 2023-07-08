package com.example.Book.My.Show.Dtos.RequestDtos;


import lombok.Data;

import java.sql.Date;

@Data
public class ShowTimingsDto {
    private Date date;
    private Integer theaterId;
    private Integer movieId;

}
