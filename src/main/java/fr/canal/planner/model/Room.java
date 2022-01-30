package fr.canal.planner.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	private String name;
	private int capacity;
	private LocalDateTime lastReservation;
	private Set<Equipment> equipments = new HashSet<Equipment>();

	public Room() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "room_name", unique = true, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "room_capacity")
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Column(name = "room_last_reservation", columnDefinition = "TIMESTAMP")
	public LocalDateTime getLastReservation() {
		return lastReservation;
	}
	
	public void setLastReservation(LocalDateTime lastReservation) {
		this.lastReservation = lastReservation;
	}
    @OneToMany( targetEntity=Equipment.class, mappedBy="room",fetch = FetchType.LAZY)
	public Set<Equipment> getEquipments() {
		return equipments;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(name, other.name);
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	
}
