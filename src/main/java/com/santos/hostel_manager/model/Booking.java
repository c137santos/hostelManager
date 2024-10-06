package com.santos.hostel_manager.model;

public class Booking {
    private String titular;
    private int idadeTitular;
    private String idBooking;
    private Room room;

    public Booking(String titular, String idBooking, Room room, int idadeTitular) {
        this.titular = titular;
        this.idBooking = idBooking; 
        this.room = room;
        this.idadeTitular = idadeTitular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getIdadeTitular() {
        return idadeTitular;
    }

    public void setIdadeTitular(int idadeTitular) {
        this.idadeTitular = idadeTitular;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public String getRoomName() {
        return room.getName();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getBookingId() {
        return idBooking;
    }

    public void editBook(String titular, Room room, int age) {
        this.titular = titular;
        this.room = room;
        this.idadeTitular = age;
    }
}