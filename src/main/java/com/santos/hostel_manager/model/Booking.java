package com.santos.hostel_manager.model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String titular;
    private String idBooking;
    private Room room;

    public Booking(String titular, String idBooking, Room room) {
        this.titular = titular;
        this.idBooking = idBooking; 
        this.room = room;
    }

    public void insertReserva(Reserva novaReserva) {
        this.reservas.add(novaReserva);
        System.out.println("Reserva inserida com sucesso: " + novaReserva);
    }

    public void displayReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}