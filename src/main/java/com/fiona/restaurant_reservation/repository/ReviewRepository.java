package com.fiona.restaurant_reservation.repository;

import com.fiona.restaurant_reservation.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer>{
}
