package com.fiona.restaurant_reservation.entity.request;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantRequest {
    private Integer id;
    private String name;
    private String ownerName;
    private String address;
    private List<String> timeslots;
    private int capacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<String> timeslots) {
        this.timeslots = timeslots;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
