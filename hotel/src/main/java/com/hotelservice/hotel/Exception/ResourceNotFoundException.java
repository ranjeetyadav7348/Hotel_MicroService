package com.hotelservice.hotel.Exception;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String s)
    {
        super(s);
    }

    public ResourceNotFoundException()
    {
        super("resouce not found");
    }
    

    
}
