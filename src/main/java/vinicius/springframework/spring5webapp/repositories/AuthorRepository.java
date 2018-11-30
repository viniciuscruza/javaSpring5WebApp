package vinicius.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vinicius.springframework.spring5webapp.model.Author;

/**
 * Criado por Vinícius Alves em 29/11/18
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
