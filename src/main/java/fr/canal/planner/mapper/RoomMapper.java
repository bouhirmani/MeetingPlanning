package fr.canal.planner.mapper;

import java.util.stream.Collectors;

import fr.canal.planner.dto.EquipmentDto;
import fr.canal.planner.dto.RoomDto;
import fr.canal.planner.model.Room;

public final class RoomMapper {

	public static Room toEntity(RoomDto dto) {
		
		Room entity = new Room();
		entity.setName(dto.getName());
		entity.setCapacity(dto.getCapacity());
		entity.setLastReservation(dto.getLastReservation());
		return entity;
	}
	public static RoomDto toDto(Room entity) {
		RoomDto dto = new RoomDto();
		dto.setName(entity.getName());
		dto.setCapacity(entity.getCapacity());
		dto.setLastReservation(entity.getLastReservation());
		dto.setEquipments(entity.getEquipments().stream().map(e->new EquipmentDto(e.getId(),e.getName())).collect(Collectors.toList()));
		return dto;
	}
	
}
