package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.Timeslot;
import com.fiona.restaurant_reservation.repository.TimeslotRepository;
import com.fiona.restaurant_reservation.service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeslotServiceImpl implements TimeslotService{
    @Autowired
    private TimeslotRepository timeslotRepository;

    @Override
    public Timeslot findById(Integer id) {
        return timeslotRepository.findOne(id);
    }
}
