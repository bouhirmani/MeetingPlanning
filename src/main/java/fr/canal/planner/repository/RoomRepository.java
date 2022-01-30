package fr.canal.planner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.canal.planner.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

	Optional<Room> findByName(String name);

}
