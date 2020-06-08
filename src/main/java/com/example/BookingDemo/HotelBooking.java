package com.example.BookingDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id; //don't forget to add getter

        private String hotelName;
        private double pricePerNight;
        private int numberOfNights;

        public HotelBooking(){}

        public HotelBooking(String hotelName, double pricePerNight, int numberOfNights) {
            this.hotelName = hotelName;
            this.pricePerNight = pricePerNight;
            this.numberOfNights = numberOfNights;
        }

    public long getId() {
        return id;
    }

    public String getHotelName() {
            return hotelName;
        }

        public double getPricePerNight() {
            return pricePerNight;
        }

        public int getNumberOfNights() {
            return numberOfNights;
        }

        public double getTotalPrice() {
            return pricePerNight * numberOfNights;
        }
    }

