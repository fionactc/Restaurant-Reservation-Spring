package com.fiona.restaurant_reservation.service;

import com.fiona.restaurant_reservation.entity.Reservation;
import com.fiona.restaurant_reservation.entity.request.ReservationRequest;

import java.util.List;

public interface ReservationService {
    public Reservation saveReservation(ReservationRequest data);
    public List<Reservation> getReservations(String userName);
    public List<Reservation> getOwnerReservations(String userName);
}
