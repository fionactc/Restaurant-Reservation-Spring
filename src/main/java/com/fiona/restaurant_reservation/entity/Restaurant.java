package com.fiona.restaurant_reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="address")
    private String address;

    @Column(name="capacity")
    private int capacity;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="ownerId")
    private User user;

    @OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnoreProperties("restaurant")
    @OrderBy("timeslot.id asc")
    private Set<TimeslotOption> timeslotOptions;

    @OneToMany(mappedBy="restaurant", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnoreProperties("restaurant")
    @OrderBy("date DESC")
    private Set<Review> reviews;

    public Set<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review) {
       reviews.add(review);
       review.setRestaurant(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        review.setRestaurant(null);
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<TimeslotOption> getTimeslotOptions() {
        return timeslotOptions;
    }

    public void setTimeslotOptions(Set<TimeslotOption> timeslotOptions) {
        this.timeslotOptions = timeslotOptions;
    }

    public void addTimeslotOptions(TimeslotOption timeslotOption) {
        timeslotOptions.add(timeslotOption);
        timeslotOption.setRestaurant(this);
    }

    public void removeTImeslotOptions(TimeslotOption timeslotOption) {
        timeslotOptions.remove(timeslotOption);
        timeslotOption.setRestaurant(null);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (id==null || obj==null || getClass() != obj.getClass())
            return false;
        Restaurant that = (Restaurant) obj;
        return id.equals(that.id);
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
