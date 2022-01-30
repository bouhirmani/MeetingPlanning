package fr.canal.planner.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.canal.planner.dto.RoomDto;
import fr.canal.planner.mapper.RoomMapper;
import fr.canal.planner.model.Room;
import fr.canal.planner.repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomRepository roomRepository;

	@Override
	public List<RoomDto> findAll() {
		List<Room> rooms =  (List<Room>)roomRepository.findAll();
		return rooms.stream().map(entity-> RoomMapper.toDto(entity)).collect(Collectors.toList());
	}
	@Override
	public RoomDto findById(int id) {
		Optional<Room> roomOptional =  roomRepository.findById(id);
		return !roomOptional.isPresent() ? null : RoomMapper.toDto(roomOptional.get());
	}
	
	@Override
	public RoomDto create(RoomDto dto) {
		return RoomMapper.toDto(roomRepository.save(RoomMapper.toEntity(dto)));
	}
	
	@Override
	public void delete(RoomDto dto) {
		roomRepository.delete(RoomMapper.toEntity(dto));
	}
	@Override
	public void update(RoomDto dto) {
	    Optional<Room> roomOptional = roomRepository.findByName(dto.getName());

	    if(roomOptional.isPresent())
	    	roomRepository.save(RoomMapper.toEntity(dto));
		
	}
}