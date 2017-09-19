package com.fiona.restaurant_reservation.repository;

import com.fiona.restaurant_reservation.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByUserName(String userName);
    User findById(int id);
}
