package com.fiona.restaurant_reservation.repository;

import com.fiona.restaurant_reservation.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
}
