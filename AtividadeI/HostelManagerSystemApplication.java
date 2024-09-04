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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santos.hostel_manager.model.Room;
import com.santos.hostel_manager.service.BookingManager;
import com.santos.hostel_manager.service.RoomManager;

import jakarta.annotation.PostConstruct;

@RestController
@SpringBootApplication
public class HostelManagerSystemApplication {

    public RoomManager rm;
	public BookingManager bm;

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

	@PostMapping("/reservar")
	public String realizarReserva(@RequestBody BookingForm bookingf){
		String roomId = bookingf.roomId;
		Room room = rm.getRoom(roomId);
		int age = bookingf.age;
		String name = bookingf.name;

		if (bookingf.bookId) {
			Booking newBooking = bm.updateReserva(age, name, roomId); 
		}
		String roomId = bookingf.roomId;
		Room room = rm.getRoom(roomId);
		if (room == null){
			return "Error";
		}
		if (bookingf.age < 18){
			return "Error. Menor de idade não pode fazer reserva";
		}
		BookingManager bm(bookingf.name, room);
		String bookId = bm.getBookId();

	}

	public static void main(String[] args) {
		SpringApplication.run(HostelManagerSystemApplication.class, args);
	}

}
