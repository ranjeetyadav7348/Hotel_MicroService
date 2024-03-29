package com.ratingservice.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ratingservice.Entities.Rating;
import com.ratingservice.Respository.RatingRepository;
import com.ratingservice.Services.RatingService;


@Component
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        // TODO Auto-generated method stub

      //  Rating res=ratingRepository
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        // TODO Auto-generated method stub
       return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        // TODO Auto-generated method stub
      return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        // TODO Auto-generated method stub
      return ratingRepository.findByHotelId(hotelId);
    }
    
}
