package com.hotelservice.micro.repositories;

import com.hotelservice.micro.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {


}
