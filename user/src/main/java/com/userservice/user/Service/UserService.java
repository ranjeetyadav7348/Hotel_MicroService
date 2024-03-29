package com.userservice.user.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.userservice.user.Entity.User;


@Component
public interface UserService {

    User saveUser(User user);

    List <User> getAllUser();


    User getUser(String userId);

    
}
