package com.fiona.restaurant_reservation.service;

import com.fiona.restaurant_reservation.entity.Review;
import com.fiona.restaurant_reservation.entity.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    Review saveReview(ReviewRequest data);
//    List<Object[]> getReviews(int restaurantId);
    List<Review> getReviews(int restaurantId);
}
