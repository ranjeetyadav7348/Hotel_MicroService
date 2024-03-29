package com.ratingservice.Services;

import java.util.List;

import com.ratingservice.Entities.Rating;

public interface RatingService {


    Rating create(Rating rating);

    List < Rating> getRating();

    List< Rating > getRatingByUserId(String userId);

    List< Rating> getRatingByHotelId(String hotelId);    
}
