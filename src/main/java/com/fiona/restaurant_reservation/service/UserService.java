package com.fiona.restaurant_reservation.service;

import com.fiona.restaurant_reservation.entity.User;

public interface UserService {
    public User saveUser(User user);
    public User findByUserName(String name);
    public User findUserById(int id);
}
