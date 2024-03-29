package com.userservice.user.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.userservice.user.Entity.Rating;




@FeignClient(name = "RATING", url = "http://localhost:8084")
public interface RatingService {



    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/ratingId")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);
    

    @DeleteMapping("/ratings/ratingId")
    public void deleteRating(@PathVariable String ratingId);



}
