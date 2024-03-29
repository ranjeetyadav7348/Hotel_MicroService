package com.hotelservice.hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.hotel.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String> {
    
}
