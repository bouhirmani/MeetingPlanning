package fr.canal.planner.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.canal.planner.dto.BookDto;
import fr.canal.planner.model.Book;
import fr.canal.planner.model.MeetingTypeEnum;

public final class BookMapper {

	public static Book toEntity(BookDto dto) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		Book book = new Book();
		book.setId(dto.getId());
		book.setNbPersons(dto.getNbPerson());
		book.setBookDate(LocalDateTime.parse(dto.getBookDate(),formatter));
		book.setStartTime(LocalDateTime.parse(dto.getStartTime(),formatter));
		book.setType(MeetingTypeEnum.valueOf(dto.getType()));//TODO to test
		
		return book;
	}
	
	public static BookDto toDto(Book entity) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		BookDto dto = new BookDto();
		dto.setId(entity.getId());
		dto.setNbPerson(entity.getNbPersons());
		dto.setBookDate(entity.getBookDate().format(formatter));
		dto.setStartTime(entity.getStartTime().format(formatter));
		dto.setType(entity.getType().name());//TODO to test
		
		return dto;
	}
}
