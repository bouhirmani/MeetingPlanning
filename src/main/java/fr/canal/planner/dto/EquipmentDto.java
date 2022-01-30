package fr.canal.planner.dto;


public class EquipmentDto {
	
	private int id;
	private String name;
	private RoomDto room;
	
	public EquipmentDto() {
		// TODO Auto-generated constructor stub
	}
	public EquipmentDto(int id, String name, RoomDto room) {
		super();
		this.id = id;
		this.name = name;
		this.room = room;
	}
	public EquipmentDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoomDto getRoom() {
		return room;
	}
	public void setRoom(RoomDto room) {
		this.room = room;
	}
	
	
}
