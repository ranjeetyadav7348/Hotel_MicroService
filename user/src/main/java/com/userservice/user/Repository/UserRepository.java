package com.userservice.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.user.Entity.User;

public interface UserRepository extends JpaRepository < User ,String> {
    
}
