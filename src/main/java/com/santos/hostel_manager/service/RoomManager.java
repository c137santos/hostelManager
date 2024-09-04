package com.santos.hostel_manager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.santos.hostel_manager.model.Room;

public class RoomManager {

    private List<Room> fake_db;

    public RoomManager() {
        fake_db = new ArrayList<>(Arrays.asList(
            new Room("Quarto Caju"),
            new Room("Quarto Abacaxi"),
            new Room("Quarto Manga")
        ));
    }
    
    public String addRoom(String roomName) {
        Room r = new Room(roomName);
        fake_db.add(r);
        return "Ok";
    }

    public List<Map<String, String>> getAll() {
        List<Map<String, String>> l = new ArrayList<>();

        for (Room room : fake_db) {
            Map<String, String> roomInfos = new HashMap<>();
            roomInfos.put("name", room.getName());
            roomInfos.put("id", room.getId());
            l.add(roomInfos);
        }
        return l;
    }
    
    public Optional<Map<String, String>> getRoom(String id) {
        for (Room room : fake_db) {
            if (room.getId().equals(id)) {
                Map<String, String> roomInfos = new HashMap<>();
                roomInfos.put("name", room.getName());
                roomInfos.put("id", room.getId());
                return Optional.of(roomInfos);
            }
        }
        return Optional.empty();
    }

    public Room getObjRoom(String id) {
        for (Room room : fake_db) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public String deleteRoom(String id) {
        Optional<Room> roomToDelete = fake_db.stream()
                                             .filter(room -> room.getId().equals(id))
                                             .findFirst();
        if (roomToDelete.isPresent()) {
            fake_db.remove(roomToDelete.get());
            return "Deletado: " + roomToDelete.get().getName();
        } else {
            return "Quarto não encontrado";
        }
    }

    public String editRoom(String id, String newName) {
        Optional<Room> roomToEdit = fake_db.stream()
                                           .filter(room -> room.getId().equals(id))
                                           .findFirst();
        if (roomToEdit.isPresent()) {
            Room room = roomToEdit.get();
            room.setName(newName);
            return "Quarto editado: " + room.getName();
        } else {
            return "Quarto não encontrado";
        }
    }

}
