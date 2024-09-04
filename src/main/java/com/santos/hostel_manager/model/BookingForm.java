package com.santos.hostel_manager.model;

public class BookingForm {
    private String name;
    private int age;
    private String roomId;
    private String bookingId;

    public BookingForm(String name, int age, String roomId, String bookingId) {
        this.name = name;
        this.age = age;
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getRoomId() {
        return roomId;
    }
}