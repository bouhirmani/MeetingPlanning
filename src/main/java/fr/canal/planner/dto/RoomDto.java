package fr.canal.planner.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RoomDto {

	private String name;
	private int capacity;
	private LocalDateTime lastReservation;
	private List<EquipmentDto> equipments;

	public RoomDto() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<EquipmentDto> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<EquipmentDto> equipments) {
		this.equipments = equipments;
	}
	public LocalDateTime getLastReservation() {
		return lastReservation;
	}
	public void setLastReservation(LocalDateTime lastReservation) {
		this.lastReservation = lastReservation;
	}
}
