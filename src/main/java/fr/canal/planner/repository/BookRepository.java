package fr.canal.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.canal.planner.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
