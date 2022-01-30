package fr.canal.planner.service;

import java.util.List;

import fr.canal.planner.dto.RoomDto;

public interface RoomService {

	List<RoomDto> findAll();
	RoomDto create(RoomDto dto);
	void delete(RoomDto dto);
	RoomDto findById(int id);
	void update(RoomDto dto);
	
}
