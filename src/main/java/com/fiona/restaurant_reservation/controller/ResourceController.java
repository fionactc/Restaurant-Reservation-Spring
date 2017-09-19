package com.fiona.restaurant_reservation.controller;

import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @RequestMapping(value="/hello")
    @PreAuthorize("hasAuthority('OWNER') or hasAuthority('CUSTOMER')")
    public String sayHello() {
        return "hello";
    }
}
