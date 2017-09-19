package com.fiona.restaurant_reservation.service;

import com.fiona.restaurant_reservation.entity.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);
    List<User> findAllUsers();
}
