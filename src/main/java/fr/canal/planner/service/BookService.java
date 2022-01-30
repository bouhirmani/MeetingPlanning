package fr.canal.planner.service;

import java.util.List;

import fr.canal.planner.dto.BookDto;

public interface BookService {

	List<BookDto> findAll();

	BookDto findById(Long id);

	BookDto create(BookDto dto);

	void delete(BookDto dto);

	
}
