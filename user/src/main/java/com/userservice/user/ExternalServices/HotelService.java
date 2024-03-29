package com.userservice.user.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.user.Entity.Hotel;

@FeignClient(name = "HOTEL", url = "http://localhost:8081")
public interface HotelService {


    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
    
}
