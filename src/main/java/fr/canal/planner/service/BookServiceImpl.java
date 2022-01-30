package fr.canal.planner.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.canal.planner.dto.BookDto;
import fr.canal.planner.mapper.BookMapper;
import fr.canal.planner.model.Book;
import fr.canal.planner.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<BookDto> findAll() {
		List<Book> books =  (List<Book>)bookRepository.findAll();
		return books.stream().map(entity->BookMapper.toDto(entity)).collect(Collectors.toList());
	}
	
	@Override
	public BookDto findById(Long id) {
		Optional<Book> bookOptional =  bookRepository.findById(id);
		return !bookOptional.isPresent() ? null : BookMapper.toDto(bookOptional.get());
	}
	
	@Override
	public BookDto create(BookDto dto) {
		return BookMapper.toDto(bookRepository.save(BookMapper.toEntity(dto)));
	}
	
	@Override
	public void delete(BookDto dto) {
		bookRepository.delete(BookMapper.toEntity(dto));
	}
	
	
}
