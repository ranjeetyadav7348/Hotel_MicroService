package com.ratingservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.Entities.Rating;
import com.ratingservice.Services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    


    @Autowired
    private RatingService ratingService;




    @GetMapping("/virat")
    public String fun()
    {
        return "this is virat";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create (@RequestBody Rating rating)
    {

          System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        Rating res= ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }
    
 
    @GetMapping
    public ResponseEntity<List <Rating>> getAll ()
    {


        List<Rating> res= ratingService.getRating();
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List <Rating>> getRatingbyUserId (@PathVariable String userId)
    {


        List<Rating> res= ratingService.getRatingByUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }
    

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List <Rating>> getRatingbyHotelId (@PathVariable String  hotelId)
    {


        List<Rating> res= ratingService.getRatingByUserId(hotelId);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    
    
}
