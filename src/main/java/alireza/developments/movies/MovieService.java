package alireza.developments.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies(){
        System.out.println(movieRepository.findAll());
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieWithImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
