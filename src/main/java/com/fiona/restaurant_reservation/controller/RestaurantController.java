package com.fiona.restaurant_reservation.controller;

import com.fiona.restaurant_reservation.entity.Restaurant;
import com.fiona.restaurant_reservation.entity.request.RestaurantRequest;
import com.fiona.restaurant_reservation.service.RestaurantService;
import com.fiona.restaurant_reservation.service.TimeslotOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api-docs")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private TimeslotOptionService timeslotOptionService;

    @GetMapping("/restaurants")
    public ResponseEntity<?> getRestaurants() {
        HttpHeaders responseHeaders = new HttpHeaders();
        List<Restaurant> lists = (List<Restaurant>)restaurantService.findAllRestaurants();
        return new ResponseEntity<List>(lists, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/restaurant")
    public ResponseEntity<?> getRestaurant(@RequestParam("id") Integer id) {
        Restaurant restaurant = restaurantService.findById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<Restaurant>(restaurant, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/owner-restaurants")
    public ResponseEntity<?> getOwnerRestaurants(@RequestParam("ownerName") String ownerName) {
        List<Restaurant> lists = (List<Restaurant>)restaurantService.findByOwnerName(ownerName);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<Restaurant>>(lists, responseHeaders, HttpStatus.OK);
    }

    @PatchMapping("/update-restaurant")
    public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantRequest data) {
        Restaurant restaurant = restaurantService.updateRestaurant(data);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<Restaurant>(restaurant, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/restaurant")
    public ResponseEntity<?> deleteRestaurant(@RequestParam("id") Integer id) {
        restaurantService.deleteById(id);
        return ResponseEntity.ok("done");
    }

    @PostMapping("/restaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantRequest data) {
        Restaurant restaurant = restaurantService.saveRestaurant(data);
        if (restaurant!= null && data.getId() == null) {
            timeslotOptionService.saveTimeslotOptions(data.getTimeslots(), restaurant);
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<Restaurant>(restaurant, responseHeaders, HttpStatus.CREATED);
    }
}

