package fr.canal.planner.model;

import java.util.Arrays;
import java.util.List;

public enum MeetingTypeEnum {
	VC("Ecran", "Pieuvre", "Webcam"), 
	SPEC("Tableau"), 
	RS("None"), 
	RC("Tableau", "Ecran", "Pieuvre");
	
	private List<String> equipments;

	private MeetingTypeEnum(String... equipments) {
		this.equipments = Arrays.asList(equipments);
	}
	public List<String> getEquipments() {
		return equipments;
	}
	
}
