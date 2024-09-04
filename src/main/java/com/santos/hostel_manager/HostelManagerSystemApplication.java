package com.santos.hostel_manager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santos.hostel_manager.model.BookingForm;
import com.santos.hostel_manager.model.Room;
import com.santos.hostel_manager.service.RoomManager;

import jakarta.annotation.PostConstruct;

@RestController
@SpringBootApplication
public class HostelManagerSystemApplication {

    public RoomManager rm;

    @PostConstruct
    public void init() {
        rm = new RoomManager();
    }

	@GetMapping("/")
	@CrossOrigin
	public List<Map<String, String> > index (){
		return rm.getAll();
	}

	@GetMapping("/{room_id}")
	public ResponseEntity<Map<String, String>> getOneRoom(@PathVariable String room_id) {
		Optional<Map<String, String>> room = rm.getRoom(room_id);
		if (room.isPresent()) {
			return ResponseEntity.ok(room.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}


	@PostMapping("/new")
	public String createRoom (@RequestBody Room room) {
		return rm.addRoom(room.getName());
	}


	@DeleteMapping("/delete/{room_id}")
	public String deleteRoom (@PathVariable String room_id) {
		return rm.deleteRoom(room_id);
	}

	@PutMapping("/edit/{room_id}")
	public String editRoom (@PathVariable String room_id, @RequestBody String new_name) {
		return rm.editRoom(room_id, new_name);
	}

	@PostMapping("/booking/{room_name}")
	public String reservaRoom(@PathVariable String room_name, @RequestBody BookingForm form){
        String name = form.getName();
        int age = form.getAge();
        String roomType = form.getRoomId();
		return "ok";
        
	}

	public static void main(String[] args) {
		SpringApplication.run(HostelManagerSystemApplication.class, args);
	}

}
