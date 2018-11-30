package vinicius.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vinicius.springframework.spring5webapp.model.Book;

/**
 * Criado por Vinícius Alves em 29/11/18
 */
public interface BookRepository extends CrudRepository<Book,Long> {
}
