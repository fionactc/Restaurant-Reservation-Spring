package com.fiona.restaurant_reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customerId")
    private User user;

    @ManyToOne
    @JoinColumn(name="timeslotOptionId")
    @JsonIgnoreProperties("reservations")
    private TimeslotOption timeslotOption;

    @Column(name="reserveDate")
    private Date reserveDate;

    @Column(name="noOfPeople")
    private int noOfPeople;

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TimeslotOption getTimeslotOption() {
        return timeslotOption;
    }

    public void setTimeslotOption(TimeslotOption timeslotOption) {
        this.timeslotOption = timeslotOption;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
}
