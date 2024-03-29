package com.userservice.user.Exception;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException()
    {
        super("Resource not found Exception");
    }

    public ResourceNotFoundException (String msg)
    {
        super(msg);
    }
    
}
