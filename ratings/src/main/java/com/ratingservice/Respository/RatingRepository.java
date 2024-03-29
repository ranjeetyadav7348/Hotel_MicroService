package com.ratingservice.Respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratingservice.Entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String> {
    

    //Custom Finder Method
    List < Rating> findByUserId(String userId);
    List < Rating> findByHotelId(String hotelId);


}
