package com.santos.hostel_manager.model;

import java.util.UUID;

public class Room {
    private String name;
    private String id;

    public Room() {
        this.id = UUID.randomUUID().toString();
    }

    public Room(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}