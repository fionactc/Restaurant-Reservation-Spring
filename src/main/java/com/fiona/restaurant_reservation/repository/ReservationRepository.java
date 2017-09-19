package com.fiona.restaurant_reservation.repository;

import com.fiona.restaurant_reservation.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
}
