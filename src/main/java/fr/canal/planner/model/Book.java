package fr.canal.planner.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	private long id;
	private int nbPersons;
    private LocalDateTime bookDate;
	private LocalDateTime startTime;
	private MeetingTypeEnum type;
	
	public Book(int nbPersons, LocalDateTime bookDate, LocalDateTime startTime, MeetingTypeEnum type) {
		super();
		this.nbPersons=nbPersons;
		this.bookDate = bookDate;
		this.startTime = startTime;
		this.type = type;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id", unique = true, nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "book_date", columnDefinition = "TIMESTAMP")
	public LocalDateTime getBookDate() {
		return bookDate;
	}
	
	public void setBookDate(LocalDateTime bookDate) {
		this.bookDate = bookDate;
	}
	
	@Column(name = "book_start_time", columnDefinition = "TIMESTAMP")
	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	@Column(name = "book_type")
    @Enumerated(EnumType.STRING)
	public MeetingTypeEnum getType() {
		return type;
	}
	public void setType(MeetingTypeEnum type) {
		this.type = type;
	}
	
	@Column(name = "book_nb_person")
	public int getNbPersons() {
		return nbPersons;
	}

	public void setNbPersons(int nbPersons) {
		this.nbPersons = nbPersons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}
	
}
