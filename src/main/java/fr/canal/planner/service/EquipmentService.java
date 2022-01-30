package fr.canal.planner.service;

import java.util.List;
import fr.canal.planner.dto.EquipmentDto;

public interface EquipmentService {
	
	List<EquipmentDto> findAll();

	EquipmentDto findById(int id);

	EquipmentDto create(EquipmentDto dto);

	void delete(EquipmentDto dto);
	
}
