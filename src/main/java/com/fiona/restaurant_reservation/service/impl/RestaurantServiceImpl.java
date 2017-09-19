package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.Restaurant;
import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.entity.request.RestaurantRequest;
import com.fiona.restaurant_reservation.repository.RestaurantRepository;
import com.fiona.restaurant_reservation.service.RestaurantService;
import com.fiona.restaurant_reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Iterable<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findByOwnerName(String userName) {
        String hql = "from Restaurant r where r.user.userName='" + userName + "'";
        List<Restaurant> restaurants = (List<Restaurant>) entityManager.createQuery(hql).getResultList();
        return restaurants;
    }

    @Override
    public Restaurant findById(Integer id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public Restaurant updateRestaurant(RestaurantRequest resp) {
        Restaurant restaurant = restaurantRepository.findOne(resp.getId());
        restaurant.setAddress(resp.getAddress());
        restaurant.setCapacity(resp.getCapacity());
        restaurant.setName(resp.getName());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant saveRestaurant(RestaurantRequest resp) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(resp.getName());
        newRestaurant.setAddress(resp.getAddress());
        newRestaurant.setCapacity(resp.getCapacity());
//        Integer id = resp.getId();
//        if (id!=null)
//            newRestaurant.setId(id);
//        System.out.println("this is id" + newRestaurant.getId());

        // find owner
        System.out.println("this is username" + resp.getOwnerName());
        User owner = userService.findByUserName(resp.getOwnerName());
        System.out.println("found owner"+ owner);
        if (owner!=null) {
            newRestaurant.setUser(owner);
        }
        return restaurantRepository.save(newRestaurant);
    }

    @Override
    public void deleteById(Integer id) {
        restaurantRepository.delete(id);
    }
}
