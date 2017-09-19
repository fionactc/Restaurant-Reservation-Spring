package com.fiona.restaurant_reservation.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="TimeslotOptions")
public class TimeslotOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy="timeslotOption", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnoreProperties("timeslotOption")
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name="timeslotId")
    private Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name="restaurantId")
    @JsonIgnoreProperties("timeslotOptions")
    private Restaurant restaurant;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof TimeslotOption )) return false;
        return id != null && id.equals(((TimeslotOption) o).id);
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservations(Reservation reservation) {
        reservations.add(reservation);
        reservation.setTimeslotOption(this);
    }

    public void removeReservations(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setTimeslotOption(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
