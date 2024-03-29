package com.userservice.user.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.user.Entity.User;
import com.userservice.user.Service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private UserService userService;



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {

       User u= userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }



    @GetMapping
    public ResponseEntity< List <User>> getAllUser()
    {

       List<User> res= userService.getAllUser();

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod ="ratingHotelFallback" )
    //  @RateLimiter(name = "ratingHotelBreaker", fallbackMethod ="ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId)
    {

       User res= userService.getUser(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }


    //creating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex)
    {
      
        ex.printStackTrace();


User u=User.builder()
           .email("dummy@gmail.com")
           .name("falane")
           .ratings(null)
           .about("fallback method calls")
           .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(u);

    }
    
}
