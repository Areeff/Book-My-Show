package com.example.Book.My.Show.Services;

import com.example.Book.My.Show.Dtos.RequestDtos.MovieEntryDto;
import com.example.Book.My.Show.Exceptions.MovieAlreadyPresentWithSameNameAndLanguage;
import com.example.Book.My.Show.Models.Movie;
import com.example.Book.My.Show.Repositories.MovieRepository;
import com.example.Book.My.Show.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws MovieAlreadyPresentWithSameNameAndLanguage {
        if(movieRepository.findByMovieName(movieEntryDto.getMovieName()) != null) {
            if(movieRepository.findByMovieName(movieEntryDto.getMovieName()).getLanguage().equals(movieEntryDto.getLanguage())){
                throw new MovieAlreadyPresentWithSameNameAndLanguage();
            }
        }
        Movie movie = MovieTransformer.movieDtoToMovie(movieEntryDto);
        movieRepository.save(movie);
        return "The movie has been added successfully";
    }
}
