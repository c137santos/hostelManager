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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.santos.hostel_manager.model.Booking;
import com.santos.hostel_manager.model.Room;
import com.santos.hostel_manager.service.BookingManager;
import com.santos.hostel_manager.service.RoomManager;

import jakarta.annotation.PostConstruct;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "*")
public class HostelManagerSystemApplication {

    public RoomManager rm;
	public BookingManager bm;

    @PostConstruct
    public void init() {
        rm = new RoomManager();
        bm = new BookingManager();
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

    @PostMapping("/delete")
    public ResponseEntity<String> deleteRoom(@RequestBody String room_id) {
        rm.deleteRoom(room_id);
        return ResponseEntity.ok("Room deleted successfully");
    }

	@PostMapping(value = "/reserva", consumes = "application/x-www-form-urlencoded")
	public @ResponseBody ResponseEntity<?> realizarReserva(@RequestParam Map<String, String> bookingf){
		int age = Integer.parseInt(bookingf.get("age"));
        String name = bookingf.get("name");
		String RoomId = bookingf.get("roomId");
		String bookingId = bookingf.get("bookingId");
		if (age < 18){
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Error. Menor de idade não pode fazer reserva");
		}
		Room room = rm.getObjRoom(RoomId);
		if (room == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		}
		Booking newBooking;
		if (bookingId == "") {
			newBooking = bm.createBooking(name, room, age); 
		} else {
			newBooking = bm.updateReserva(name, room, age, bookingId);

		}
		return ResponseEntity.ok().body(newBooking.getBookingId());

	}

	@GetMapping("reserva/listar")
	@CrossOrigin
	public List<Map<String, Object> > listarReservas (){
		return bm.getAllBookings();
	}

	@DeleteMapping("reserva/excluir")
	public List<Map<String, Object> > excluirReserva (){
		return bm.getAllBookings();
	}

    @PostMapping("reserva/delete")
    public ResponseEntity<String> deleteReserva(@RequestParam Map<String, String> bookingid) {
		String reservationId = bookingid.get("id");
        bm.excluirReserva(reservationId);
        return ResponseEntity.ok("Room deleted successfully");
    }

	public static void main(String[] args) {
		SpringApplication.run(HostelManagerSystemApplication.class, args);
	}

}
