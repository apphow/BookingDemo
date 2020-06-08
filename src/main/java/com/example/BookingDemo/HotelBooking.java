package com.example.BookingDemo;

public class HotelBooking {
        private String hotelName;
        private double pricePerNight;
        private int numberOfNights;

        public HotelBooking(){}

        public HotelBooking(String hotelName, double pricePerNight, int numberOfNights) {
            this.hotelName = hotelName;
            this.pricePerNight = pricePerNight;
            this.numberOfNights = numberOfNights;
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

