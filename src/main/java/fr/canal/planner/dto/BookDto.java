package fr.canal.planner.dto;

public class BookDto {
	
	private long id;
	private int nbPerson;
    private String bookDate;
	private String startTime;
	private String type;
	
	public BookDto(long id, int nbPerson, String bookDate, String startTime, String type) {
		super();
		this.id = id;
		this.nbPerson=nbPerson;
		this.bookDate = bookDate;
		this.startTime = startTime;
		this.type = type;
	}
	public BookDto() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNbPerson() {
		return nbPerson;
	}
	public void setNbPerson(int nbPerson) {
		this.nbPerson = nbPerson;
	}
	
}
