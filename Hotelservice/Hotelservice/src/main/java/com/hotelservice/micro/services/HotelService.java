package com.hotelservice.micro.services;

import com.hotelservice.micro.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);


    //getall
    List<Hotel> getAll();



    //get single
    Hotel get(String id);


}
