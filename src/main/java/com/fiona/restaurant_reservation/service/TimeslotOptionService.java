package com.fiona.restaurant_reservation.service;

import com.fiona.restaurant_reservation.entity.Restaurant;
import com.fiona.restaurant_reservation.entity.TimeslotOption;

import java.util.List;

public interface TimeslotOptionService {
    public void saveTimeslotOptions(List<String> timeslots, Restaurant restaurant);
    public TimeslotOption findById(Integer id);
}
