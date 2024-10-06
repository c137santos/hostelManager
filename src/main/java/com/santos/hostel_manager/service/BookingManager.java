package com.santos.hostel_manager.service;

import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.santos.hostel_manager.model.Booking;
import com.santos.hostel_manager.model.Room;


public class BookingManager {

    private List<Booking> db_fake;

    public BookingManager() {
        this.db_fake = new ArrayList<>();
    }

    public Booking createBooking(String titular, Room room, int age) {
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(titular, bookingId, room, age);
        db_fake.add(booking);
        return booking;
    }

    public Booking getBookId(String bookId) {
        for (Booking book : db_fake) {
            if (book.getBookingId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public List<Map<String, Object>> getAllBookings() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Booking booking : db_fake) {
            Map<String, Object> bookingMap = new HashMap<>();
            bookingMap.put("id", booking.getIdBooking());
            bookingMap.put("name", booking.getTitular());
            bookingMap.put("age", booking.getIdadeTitular());
            bookingMap.put("roomName", booking.getRoomName());
            bookingMap.put("bookingCode", booking.getBookingId());
            result.add(bookingMap);
        }
        return result;
    }

    public Booking updateReserva(String titular, Room room, int age, String bookId) {
        Booking book = getBookId(bookId);
        if (book != null) {
            book.editBook(titular, room, age);
        }
        return book;
    }

    public boolean excluirReserva(String bookId) {
        Iterator<Booking> iterator = db_fake.iterator();
        while (iterator.hasNext()) {
            Booking book = iterator.next();
            if (book.getBookingId().equals(bookId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

