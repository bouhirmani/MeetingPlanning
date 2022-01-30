package fr.canal.planner.dto;

public class PlanningDto {

	private RoomDto room;
	private BookDto book;
	
	public PlanningDto(RoomDto room, BookDto book) {
		super();
		this.room = room;
		this.book = book;
	}
	public RoomDto getRoom() {
		return room;
	}
	public void setRoom(RoomDto room) {
		this.room = room;
	}
	public BookDto getBook() {
		return book;
	}
	public void setBook(BookDto book) {
		this.book = book;
	}
	
}
