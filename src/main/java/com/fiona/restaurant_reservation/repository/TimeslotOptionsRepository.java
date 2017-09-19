package com.fiona.restaurant_reservation.repository;

import com.fiona.restaurant_reservation.entity.TimeslotOption;
import org.springframework.data.repository.CrudRepository;

public interface TimeslotOptionsRepository extends CrudRepository<TimeslotOption, Integer>{
}
