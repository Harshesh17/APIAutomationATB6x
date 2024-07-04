package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingDates;
import com.thetestingacademy.pojos.BookingResponse;

public class PayloadManager {
    Gson gson;
    
    public String createPayloadBookingAsString() {


        Booking booking = new Booking();
        booking.setFirstname("John");
        booking.setLastname("Doe");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2019-01-01");
        bookingdates.setCheckout("2019-01-02");
        booking.setBookingdates(bookingdates);
        booking.setAddtionalneeds("Breakfast");
        gson = new Gson();
        gson.toJson(booking);
        String jsonPayload = gson.toJson(booking);
        return jsonPayload;
    }

    public String createInvalidPayloadAsString() {
        return "{}";
    }
    public String fullupdatePayloadAsString() {


        Booking booking = new Booking();
        booking.setFirstname("Harshesh");
        booking.setLastname("Pote");
        booking.setTotalprice(800);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-06-07");
            bookingdates.setCheckout("2024-06-10");
            booking.setBookingdates(bookingdates);
            booking.setAddtionalneeds("Breakfast , Lunch");
            return gson.toJson(booking);
        
        
    }

    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingRespons = gson.fromJson(responseString, BookingResponse.class);
        return bookingRespons;
    }
}