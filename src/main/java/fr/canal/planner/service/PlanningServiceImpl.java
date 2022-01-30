package fr.canal.planner.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.canal.planner.dto.EquipmentDto;
import fr.canal.planner.dto.PlanningDto;
import fr.canal.planner.dto.RoomDto;
import fr.canal.planner.model.MeetingTypeEnum;

@Service
@Transactional
public class PlanningServiceImpl implements PlanningService{

	
	@Autowired
	EquipmentService equipmentService;

	@Autowired
	BookService bookService;
	
	@Autowired
	RoomService roomService;

	
	
	@Override
	public List<PlanningDto>generatePlanning(){
		
		List<RoomDto>rooms = roomService.findAll();
		List<PlanningDto>plannings = new ArrayList<PlanningDto>();
		
		/* 
		 * startTime Between 8h and 17h
		 * Not during weekend
		 */
		bookService.findAll().stream().filter(book-> 
		toLocalDateTime(book.getStartTime()).getHour() >= 8 && 
		toLocalDateTime(book.getStartTime()).getHour() <=17 &&
		!isWeekend(toLocalDateTime(book.getStartTime()).toLocalDate()))
			.forEach(book->{
				Optional<RoomDto>roomOptional = rooms.stream().filter(room-> 
					isRoomCapacityOK(room, book.getNbPerson()) && 
					isRoomContainsEquipmentsByType(room,book.getType()) &&
					isRoomAvailable(room,toLocalDateTime(book.getStartTime()))
				).findFirst();
				if(roomOptional.isPresent()) { 
					roomOptional.get().setLastReservation(toLocalDateTime(book.getStartTime()));
					roomService.update(roomOptional.get());
					plannings.add(new PlanningDto(roomOptional.get(),book));
				}
			});
		return plannings;
	}
	
	/*
	 * 70% of capacity cause of COVID
	 * */
	private boolean isRoomCapacityOK(RoomDto room, int bookCapacity) {
		return (int)(room.getCapacity() * 70 /100) >= bookCapacity;
	}
	/*
	 * Room must be free 1 hour before its next reservation 
	 * We add 2 hours to lastReservation : 1h for meeting + 1 hour for cleanning the room.
	 * */
	private boolean isRoomAvailable(RoomDto room, LocalDateTime startTime) {
		return startTime.isAfter(room.getLastReservation().plusHours(2));
	}
	/*
	 * Is Room contains equipments by MeetingTypeEnum
	 * */
	private static boolean isRoomContainsEquipmentsByType(RoomDto room, String type) {
		return MeetingTypeEnum.valueOf(type).getEquipments().stream().allMatch(equipment-> 
				room.getEquipments().stream().map(EquipmentDto::getName).collect(Collectors.toList()).contains(equipment));
	}
	private static LocalDateTime toLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		return LocalDateTime.parse(date, formatter);
	}
	public static boolean isWeekend(final LocalDate date)
    {
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }
	
	
	
	
	
}
