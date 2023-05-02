package alireza.developments.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Review> postReview(@RequestBody Map<String, String> payload) {
        System.out.println("post received");
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("body"), payload.get("imdbId"))
                , HttpStatus.OK);
    }
    //bear in mind the value received from the api must match payload's parameters in this case "body" and "imdbId"


}
