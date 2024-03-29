package com.hotelservice.hotel.Service;

import java.util.List;

import com.hotelservice.hotel.Entity.Hotel;

public interface HotelService {


    Hotel create(Hotel hotel);
    List <Hotel> getAll();

    Hotel get(String id);

    
}
