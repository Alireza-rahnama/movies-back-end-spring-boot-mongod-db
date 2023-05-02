package alireza.developments.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> findAllReviews(){

        return reviewRepository.findAll();
    }

    public Review createReview(String body, String imdbId){

        //write a review and insert it to database review collection
        Review review = reviewRepository.insert(new Review(body));


        //update the review and add it to the list of reviewIds in database movie collection
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first(); //this will make sure we only get and update one single movie

        return review;
    }

}
