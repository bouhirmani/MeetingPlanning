package fr.canal.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.canal.planner.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{

}
