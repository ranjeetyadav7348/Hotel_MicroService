package com.userservice.user.ServiceImpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.userservice.user.Entity.Hotel;
import com.userservice.user.Entity.Rating;
import com.userservice.user.Entity.User;
import com.userservice.user.ExternalServices.HotelService;
import com.userservice.user.Repository.UserRepository;
import com.userservice.user.Service.UserService;





@Component
public class UserServiceImpl implements UserService{


    @Autowired
    private RestTemplate restTemplate;



    @Autowired
    HotelService hotelService;

    @Autowired
    private UserRepository userRepository;


    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);





    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub

        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
       return  userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // TODO Auto-generated method stub
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Id is not found "+userId));
    


      Rating[] obj=  restTemplate.getForObject("http://RATING/ratings/user/"+user.getUserId(),Rating[].class );

      logger.info("{}",obj);




      List < Rating> list= Arrays.stream(obj).toList();


      List < Rating> ratinglist=  list.stream().map(rating-> 
      {
       // ResponseEntity< Hotel> forEntity= restTemplate.getForEntity("http://HOTEL/hotels/"+rating.getHotelId(), Hotel.class);
        Hotel hotel= hotelService.getHotel(rating.getHotelId());
       // logger.info("respons status Code ", forEntity.getStatusCode());
        rating.setHotel(hotel);
        return rating;
    }).collect(Collectors.toList());


   user.setRatings(ratinglist);

        return user;
    }
    
}
