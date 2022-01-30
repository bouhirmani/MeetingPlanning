package fr.canal.planner.mapper;

import fr.canal.planner.dto.EquipmentDto;
import fr.canal.planner.model.Equipment;

public final class EquipmentMapper {

	public static Equipment toEntity(EquipmentDto dto) {
		Equipment equipment = new Equipment();
		equipment.setId(dto.getId());
		equipment.setName(dto.getName());
		equipment.setRoom(RoomMapper.toEntity(dto.getRoom()));
		return equipment;
	}
	public static EquipmentDto toDto(Equipment entity) {
		EquipmentDto dto = new EquipmentDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setRoom(RoomMapper.toDto(entity.getRoom()));
		return dto;
	}
}
