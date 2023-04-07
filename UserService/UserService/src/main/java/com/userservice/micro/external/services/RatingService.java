package com.userservice.micro.external.services;

import com.userservice.micro.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATING-SERVICE-MICRO")
public interface RatingService {

//post
    @PostMapping("/ratings")
    public Rating createRating(Rating values );

    //put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

//Delete(method nhi bana h esliye use nhi kr rhe)
    //@DeleteMapping("/ratings/{ratingId}")
   // public void deleteRating(@PathVariable("ratingId") String ratingId);

}
