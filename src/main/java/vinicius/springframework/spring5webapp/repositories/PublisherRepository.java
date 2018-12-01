package vinicius.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vinicius.springframework.spring5webapp.model.Publisher;

/**
 * Criado por Vinícius Alves em 01/12/18
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
