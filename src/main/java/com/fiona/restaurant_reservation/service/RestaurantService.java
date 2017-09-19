package com.fiona.restaurant_reservation.service;

import com.fiona.restaurant_reservation.entity.Restaurant;
import com.fiona.restaurant_reservation.entity.request.RestaurantRequest;

import java.util.List;

public interface RestaurantService {
   Iterable<Restaurant> findAllRestaurants();
//   Restaurant saveRestaurant(Restaurant restaurant);
   Restaurant saveRestaurant(RestaurantRequest resp);
   Restaurant updateRestaurant(RestaurantRequest resp);
   Restaurant findById(Integer id);
   List<Restaurant> findByOwnerName(String userName);
   void deleteById(Integer id);
}
