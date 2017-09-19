package com.fiona.restaurant_reservation.controller;

import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.entity.request.ApiError;
import com.fiona.restaurant_reservation.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolationException;

@Controller
@RequestMapping("/api-docs")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User data) {
        HttpHeaders responseHeaders = new HttpHeaders();

        // find user by name
        User existingUser = userService.findByUserName(data.getUserName());
        if (existingUser != null) {
            String error = "Username already exists";

            //TODO: react axios error interceptor is broken, have to return OK for now
            return new ResponseEntity<String>(error, responseHeaders, HttpStatus.OK);
        }

        User savedUser = userService.saveUser(data);
        return new ResponseEntity<User>(savedUser, responseHeaders, HttpStatus.CREATED);
    }
}
