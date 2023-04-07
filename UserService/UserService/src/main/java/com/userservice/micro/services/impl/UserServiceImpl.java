package com.userservice.micro.services.impl;

import com.userservice.micro.entities.Hotel;
import com.userservice.micro.entities.Rating;
import com.userservice.micro.entities.User;
import com.userservice.micro.exceptions.ResourceNotFoundException;
import com.userservice.micro.external.services.HotelService;
import com.userservice.micro.repositories.UserRepository;
import com.userservice.micro.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
 @Autowired
   private RestTemplate restTemplate;
@Autowired
   private HotelService hotelService;
    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
       String randomUserId=UUID.randomUUID().toString();
       user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get user from database with the help of user repository
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with give ID is not found on the Server!!:"+userId));
        //fetch Rating of the above user from the Rating Service
        // http://localhost:8083/ratings/users/91914dcd-b737-4607-b15a-d16794d604b8

        Rating[] ratingsOfUser= restTemplate.getForObject("http://RATING-SERVICE-MICRO/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating->{
            // api call to hotel service to get the hotel
            //http://localhost:8082/hotels/68d3ad2d-2726-4170-ac68-054860c405da


            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE-MICRO/hotels/"+rating.getHotelId(), Hotel.class);

          //Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
          //logger.info("response status code: {}",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);

            //return rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
