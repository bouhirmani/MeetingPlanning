package fr.canal.planner.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.canal.planner.dto.EquipmentDto;
import fr.canal.planner.mapper.EquipmentMapper;
import fr.canal.planner.model.Equipment;
import fr.canal.planner.repository.EquipmentRepository;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService{

	@Autowired
	EquipmentRepository equipmentRepository;

	@Override
	public List<EquipmentDto> findAll() {
		List<Equipment> equipments =  (List<Equipment>)equipmentRepository.findAll();
		return equipments.stream().map(entity->EquipmentMapper.toDto(entity)).collect(Collectors.toList());
	}
	@Override
	public EquipmentDto findById(int id) {
		Optional<Equipment> equipmentOptional =  equipmentRepository.findById(id);
		return !equipmentOptional.isPresent() ? null : EquipmentMapper.toDto(equipmentOptional.get());
	}
	
	@Override
	public EquipmentDto create(EquipmentDto dto) {
		return EquipmentMapper.toDto(equipmentRepository.save(EquipmentMapper.toEntity(dto)));
	}
	
	@Override
	public void delete(EquipmentDto dto) {
		equipmentRepository.delete(EquipmentMapper.toEntity(dto));
	}
	
}
