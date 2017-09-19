package com.fiona.restaurant_reservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="rating")
    private int rating;

    @Column(name="content")
    private String content;

    @Column(name="date")
    private Date date;

    @Column(name="isFilledIn")
    private Boolean isFilledIn;

    @ManyToOne
    @JoinColumn(name="customerId")
    private User user;

    @ManyToOne
    @JoinColumn(name="restaurantId")
    @JsonIgnoreProperties("reviews")
    private Restaurant restaurant;

    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Review )) return false;
        return id != null && id.equals(((Review) o).id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getFilledIn() {
        return isFilledIn;
    }

    public void setFilledIn(Boolean filledIn) {
        isFilledIn = filledIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
