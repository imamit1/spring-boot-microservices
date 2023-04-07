package com.userservice.micro.services;

import com.userservice.micro.entities.User;

import java.util.List;

public interface UserService {

    //user operation
    //create user
    User saveUser(User user);

    // get all User

    List<User> getAllUser();

    // get Single User

    User getUser(String userId);


}
