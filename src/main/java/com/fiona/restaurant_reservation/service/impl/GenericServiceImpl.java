package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.repository.UserRepository;
import com.fiona.restaurant_reservation.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }


    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
