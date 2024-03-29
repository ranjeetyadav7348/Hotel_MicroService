package com.userservice.user.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    

    private String id;
    private String name;
    private String location;
    private String about;
}
