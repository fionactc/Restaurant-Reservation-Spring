package com.fiona.restaurant_reservation.controller;

import com.fiona.restaurant_reservation.entity.Review;
import com.fiona.restaurant_reservation.entity.request.ReviewRequest;
import com.fiona.restaurant_reservation.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/api-docs")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<?> getReviews (@RequestParam("id") int restaurantId) {
        System.out.println("this is id"+ restaurantId);
        List<Review> reviews =  reviewService.getReviews(restaurantId);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<Review>>(reviews, responseHeaders, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<?> saveReview(@RequestBody ReviewRequest data) {
        System.out.println(data.getContent());
        System.out.println(data.getRestaurantId());
        Review review = reviewService.saveReview(data);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<Review>(review, responseHeaders, HttpStatus.CREATED);
    }
}
