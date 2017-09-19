package com.fiona.restaurant_reservation.repository;

import com.fiona.restaurant_reservation.entity.Timeslot;
import org.springframework.data.repository.CrudRepository;

public interface TimeslotRepository extends CrudRepository<Timeslot, Integer>{
}
