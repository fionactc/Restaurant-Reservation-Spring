package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.Restaurant;
import com.fiona.restaurant_reservation.entity.Timeslot;
import com.fiona.restaurant_reservation.entity.TimeslotOption;
import com.fiona.restaurant_reservation.repository.TimeslotOptionsRepository;
import com.fiona.restaurant_reservation.service.TimeslotOptionService;
import com.fiona.restaurant_reservation.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeslotOptionsServiceImpl implements TimeslotOptionService{
    @Autowired
    private TimeslotOptionsRepository timeslotOptionsRepository;

    @Autowired
    private TimeslotService timeslotService;

    @Override
    public TimeslotOption findById(Integer id) {
        return timeslotOptionsRepository.findOne(id);
    }

    @Override
    public void saveTimeslotOptions(List<String> timeslots, Restaurant restaurant) {
        for (String timeslotId : timeslots) {
           TimeslotOption newOption = new TimeslotOption();
           newOption.setRestaurant(restaurant);
           Timeslot timeslot = timeslotService.findById(Integer.parseInt(timeslotId));
           if (timeslot!=null) {
               newOption.setTimeslot(timeslot);
               timeslotOptionsRepository.save(newOption);
           }
        }
    }
}
