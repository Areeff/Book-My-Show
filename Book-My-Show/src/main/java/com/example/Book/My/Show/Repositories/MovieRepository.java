package com.example.Book.My.Show.Repositories;

import com.example.Book.My.Show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findByMovieName(String name);
}
