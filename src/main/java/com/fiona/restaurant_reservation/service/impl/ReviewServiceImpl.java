package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.Restaurant;
import com.fiona.restaurant_reservation.entity.Review;
import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.entity.request.ReviewRequest;
import com.fiona.restaurant_reservation.repository.ReviewRepository;
import com.fiona.restaurant_reservation.service.RestaurantService;
import com.fiona.restaurant_reservation.service.ReviewService;
import com.fiona.restaurant_reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private EntityManager entityManager;

    @Override
//    public List<Object[]> getReviews(int restaurantId) {
    public List<Review> getReviews(int restaurantId) {
//        String hql = "from Review review left join fetch review.
//        String hql = "from Review review " +
//                "left join review.user as user " +
//                "with review.restaurantId=" + restaurantId;
//        String hql = "select r.id, r.rating, r.content, r.date, r.user.lastName, r.user.firstName from Review r" +
//                " where r.restaurant.id=" + String.valueOf(restaurantId);
        String hql = "from Review r where r.restaurant.id=" + String.valueOf(restaurantId) + " order by r.date desc";
        List<Review> reviews = (List<Review>) entityManager.createQuery(hql).getResultList();
//        List<Object[]> reviews = entityManager.createQuery(hql).getResultList();
        return reviews;
    }

    @Override
    public Review saveReview(ReviewRequest data) {
        Review review = new Review();
        review.setContent(data.getContent());
        review.setDate(data.getDate());
//        System.out.println("HELLOOOOOO");
//        System.out.println(data.getRestaurant().getId());
//        review.setRestaurant(data.getRestaurant());
        System.out.println(data.getRestaurantId());
        Restaurant restaurant = restaurantService.findById(data.getRestaurantId());
        System.out.println(restaurant.getName());
        review.setRestaurant(restaurant);
        review.setRating(data.getRating());

        // find user
        User owner = userService.findByUserName(data.getCustomerName());
        if (owner!=null) {
            review.setUser(owner);
        }
        return reviewRepository.save(review);
    }
}
