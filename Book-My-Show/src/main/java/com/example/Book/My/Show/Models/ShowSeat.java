package com.example.Book.My.Show.Models;

import com.example.Book.My.Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "ShowSeats")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;
    private Boolean isAvailable;
    private Boolean isFoodContains;

    @ManyToOne
    @JoinColumn
    private Show show;
}
