package fr.canal.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.canal.planner.dto.BookDto;
import fr.canal.planner.dto.EquipmentDto;
import fr.canal.planner.dto.PlanningDto;
import fr.canal.planner.dto.RoomDto;
import fr.canal.planner.service.BookService;
import fr.canal.planner.service.EquipmentService;
import fr.canal.planner.service.PlanningService;
import fr.canal.planner.service.RoomService;

@RestController
public class BookingController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	EquipmentService equipmentService;
	
	@Autowired
	PlanningService planningService;

	@GetMapping("/books")
    public ResponseEntity<List<BookDto>> allBooks() {
		return new ResponseEntity<>(bookService.findAll(), HttpStatus.CREATED);
    }
	@PostMapping("/books")
	public ResponseEntity<BookDto> create(@RequestBody BookDto book) {
		return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
	}
	@GetMapping("/rooms")
	public ResponseEntity<List<RoomDto>> allRooms() {
		return new ResponseEntity<>(roomService.findAll(), HttpStatus.CREATED);
	}
	@PostMapping("/rooms")
	public ResponseEntity<RoomDto> create(@RequestBody RoomDto room) {
		return new ResponseEntity<>(roomService.create(room), HttpStatus.CREATED);
	}
	@GetMapping("/equipments")
	public ResponseEntity<List<EquipmentDto>> allEquipments() {
		return new ResponseEntity<>(equipmentService.findAll(), HttpStatus.CREATED);
	}
	@PostMapping("/equipments")
	public ResponseEntity<EquipmentDto> create(@RequestBody EquipmentDto equipment) {
		return new ResponseEntity<>(equipmentService.create(equipment), HttpStatus.CREATED);
	}
	
	@GetMapping("/planning")
	public ResponseEntity<List<PlanningDto>> plannings() {
		return new ResponseEntity<>(planningService.generatePlanning(), HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
