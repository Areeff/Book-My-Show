package com.example.Book.My.Show.Repositories;

import com.example.Book.My.Show.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {

    Theater findByAddress(String address);
}
