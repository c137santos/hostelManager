package com.santos.hostel_manager.service;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List; 

import com.santos.hostel_manager.model.Booking;
import com.santos.hostel_manager.model.Room;


public class BookingManager {

    private List<Booking> db_fake;

    public BookingManager() {

        this.db_fake = new ArrayList<>();
    }

    public Booking createBooking(String titular, String roomId, int age) {
        RoomManager rm = new RoomManager();
        Room room = rm.getObjRoom(roomId);
        String bookingId = UUID.randomUUID().toString();
        if(age<18){
            return "error";
        }
        Booking booking = new Booking(titular, bookingId, room);
        return booking;
    
    }

    public void displayBookingDetails() {
        System.out.println("Titular: " + this.titular);
        System.out.println("ID: " + this.bookingId);
    }

    public String getBookId(){
        return bookingId;
    }

    public Booking updateReserva(int age, String name, String roomId, ){

    };
}

