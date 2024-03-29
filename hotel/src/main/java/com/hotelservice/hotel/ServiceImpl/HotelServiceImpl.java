package com.hotelservice.hotel.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotelservice.hotel.Entity.Hotel;
import com.hotelservice.hotel.Exception.ResourceNotFoundException;
import com.hotelservice.hotel.Repository.HotelRepository;
import com.hotelservice.hotel.Service.HotelService;


@Component
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        // TODO Auto-generated method stub


        String id= UUID.randomUUID().toString();
        hotel.setId(id);

    
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        // TODO Auto-generated method stub
       return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        // TODO Auto-generated method stub
      return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel id is not found"));
    }
    
}
