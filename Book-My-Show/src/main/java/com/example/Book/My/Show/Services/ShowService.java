package com.example.Book.My.Show.Services;

import com.example.Book.My.Show.Dtos.RequestDtos.ShowEntryDto;
import com.example.Book.My.Show.Dtos.RequestDtos.ShowSeatEntryDto;
import com.example.Book.My.Show.Dtos.RequestDtos.ShowTimingsDto;
import com.example.Book.My.Show.Enums.SeatType;
import com.example.Book.My.Show.Exceptions.MovieDoesNotExists;
import com.example.Book.My.Show.Exceptions.ShowDoesNotExists;
import com.example.Book.My.Show.Exceptions.TheaterDoesNotExists;
import com.example.Book.My.Show.Models.*;
import com.example.Book.My.Show.Repositories.MovieRepository;
import com.example.Book.My.Show.Repositories.ShowRepository;
import com.example.Book.My.Show.Repositories.TheaterRepository;
import com.example.Book.My.Show.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(ShowEntryDto showEntryDto) throws MovieDoesNotExists, TheaterDoesNotExists {
        Show show = ShowTransformer.showDtoToShow(showEntryDto);

        Optional<Movie> movieOpt = movieRepository.findById(showEntryDto.getMovieId());
        if(movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }
        Optional<Theater> theaterOpt = theaterRepository.findById(showEntryDto.getTheaterId());
        if(theaterOpt.isEmpty()) {
            throw new TheaterDoesNotExists();
        }

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been added Successfully";
    }

    public String associateShowSeats(ShowSeatEntryDto showSeatEntryDto) throws ShowDoesNotExists {
        Optional<Show> showOpt = showRepository.findById(showSeatEntryDto.getShowId());
        if(showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }
        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();
        for(TheaterSeat theaterSeat : theaterSeatList) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice((showSeatEntryDto.getPriceOfClassicSeat()));
            } else {
                showSeat.setPrice(showSeatEntryDto.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContains(Boolean.FALSE);

            showSeatList.add(showSeat);
        }
        showRepository.save(show);

        return "Show seats have been associated successfully";
    }

    public List<Time> showTimingsOnDate(ShowTimingsDto showTimingsDto) {
        Date date = showTimingsDto.getDate();
        Integer theaterId = showTimingsDto.getTheaterId();
        Integer movieId = showTimingsDto.getMovieId();
        return showRepository.getShowTimingsOnDate(date, theaterId, movieId);
    }

    public String movieHavingMostShows() {
        Integer movieId = showRepository.getMostShowsMovie();
        return movieRepository.findById(movieId).get().getMovieName();
    }

}
