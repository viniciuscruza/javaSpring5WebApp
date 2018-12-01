package vinicius.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import vinicius.springframework.spring5webapp.model.Author;
import vinicius.springframework.spring5webapp.model.Book;
import vinicius.springframework.spring5webapp.model.Publisher;
import vinicius.springframework.spring5webapp.repositories.AuthorRepository;
import vinicius.springframework.spring5webapp.repositories.BookRepository;
import vinicius.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * Criado por Vinícius Alves em 29/11/18
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {


        Publisher editoraAlves = new Publisher("Editora Alves", "Rua dos bobos, 0");
        publisherRepository.save(editoraAlves);

        //Vinícius
        Author vinicius = new Author("Vinicius", "Alves");
        Book learningSpring = new Book("Learning Spring Vol. 1", "1234", editoraAlves);

        learningSpring.getAuthors().add(vinicius);

        authorRepository.save(vinicius);
        bookRepository.save(learningSpring);

        Publisher editoraNova = new Publisher("Editora Nova", "Novo Endereço, 30");
        publisherRepository.save(editoraNova);

        //Barbara
        Author barbara = new Author("Barbara", "Alves");

        Book tratamentoVocal = new Book("Tratamento Vocal", "2345" , editoraNova);

        barbara.getBooks().add(tratamentoVocal);

        authorRepository.save(barbara);
        bookRepository.save(tratamentoVocal);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
