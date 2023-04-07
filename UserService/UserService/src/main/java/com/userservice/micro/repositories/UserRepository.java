package com.userservice.micro.repositories;

import com.userservice.micro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


}
