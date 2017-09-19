package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.repository.UserRepository;
import com.fiona.restaurant_reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        // convert password to encrypted value
        ShaPasswordEncoder pe = new ShaPasswordEncoder(256);
        String encodedPassword = pe.encodePassword(user.getPassword(), null);
        user.setPassword(encodedPassword);

        // save user through repository
        return userRepository.save(user);
    }
    public User findByUserName(String name) {
        return userRepository.findByUserName(name);
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }
}
