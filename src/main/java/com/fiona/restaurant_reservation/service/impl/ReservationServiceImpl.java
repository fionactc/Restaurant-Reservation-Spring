package com.fiona.restaurant_reservation.service.impl;

import com.fiona.restaurant_reservation.entity.Reservation;
import com.fiona.restaurant_reservation.entity.TimeslotOption;
import com.fiona.restaurant_reservation.entity.User;
import com.fiona.restaurant_reservation.entity.request.ReservationRequest;
import com.fiona.restaurant_reservation.repository.ReservationRepository;
import com.fiona.restaurant_reservation.repository.UserRepository;
import com.fiona.restaurant_reservation.service.ReservationService;
import com.fiona.restaurant_reservation.service.TimeslotOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeslotOptionService timeslotOptionService;

    @Override
    public List<Reservation> getReservations(String userName) {
        String hql = "from Reservation r where r.user.userName='" + userName + "' " +
                "order by r.reserveDate asc ";
        List<Reservation> reservations = (List<Reservation>) entityManager.createQuery(hql).getResultList();
        return reservations;
    }

    @Override
    public List<Reservation> getOwnerReservations(String userName) {
        String hql = "from Reservation r where r.timeslotOption.restaurant.user.userName='" + userName + "'";
//        String hql = "select r.user.firstName as firstName, r.user.lastName, r.timeslotOption.timeslot.time, r.reserveDate, r.noOfPeople, r.timeslotOption.restaurant.name " +
//                "from Reservation r where r.timeslotOption.restaurant.user.userName='" + userName + "'";
        List<Reservation> reservations = (List<Reservation>) entityManager.createQuery(hql).getResultList();
        return reservations;
    }

    @Override
    public Reservation saveReservation(ReservationRequest data) {
        Reservation reservation = new Reservation();
        System.out.println(data.getDate());
        reservation.setReserveDate(data.getDate());
        reservation.setNoOfPeople(data.getNoOfPeople());
        // Link to user
        User user = userRepository.findByUserName(data.getCustomerName());
        reservation.setUser(user);
        // Link to timeslotOption
        TimeslotOption option = timeslotOptionService.findById(data.getTimeslotOptionId());
        reservation.setTimeslotOption(option);

        return reservationRepository.save(reservation);
    }
}
