package com.fiona.restaurant_reservation.controller;

import com.fiona.restaurant_reservation.entity.Reservation;
import com.fiona.restaurant_reservation.entity.request.ReservationRequest;
import com.fiona.restaurant_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api-docs")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/owner-reservations")
    public ResponseEntity<?> getOwnerReservations(@RequestParam("username") String userName) {
        System.out.println("Hello");
        List<Reservation> reservations = reservationService.getOwnerReservations(userName);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<Reservation>>(reservations, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/reservations")
    public ResponseEntity<?> getReservations(@RequestParam("username") String userName) {
        List<Reservation> reservations = reservationService.getReservations(userName);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<List<Reservation>>(reservations, responseHeaders, HttpStatus.OK);
    }

//    @GetMapping("/availability")
//    public ResponseEntity<?> getAvailability(@RequestParam("id") Integer restaurantId) {
//select sum(r.noOfPeople), r.timeslotOption.id, r.timeslotOption.timeslot.time, r.reserveDate from Reservation r group by r.timeslotOption.id, r.reserveDate order by r.reserveDate asc
//    }

    @PostMapping("/reservation")
    public ResponseEntity<?> saveReservation(@RequestBody ReservationRequest data) {
        Reservation reservation = reservationService.saveReservation(data);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<Reservation>(reservation, responseHeaders, HttpStatus.CREATED);
    }
}
