package com.fiona.restaurant_reservation.entity.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ReservationRequest {
   private int timeslotOptionId;
   private String customerName;

   @JsonFormat(pattern="yyyy-MM-dd")
   private Date date;

   private int noOfPeople;

   public int getTimeslotOptionId() {
      return timeslotOptionId;
   }

   public void setTimeslotOptionId(int timeslotOptionId) {
      this.timeslotOptionId = timeslotOptionId;
   }

   public String getCustomerName() {
      return customerName;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public int getNoOfPeople() {
      return noOfPeople;
   }

   public void setNoOfPeople(int noOfPeople) {
      this.noOfPeople = noOfPeople;
   }
}
