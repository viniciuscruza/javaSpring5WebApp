package vinicius.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import vinicius.springframework.spring5webapp.model.Author;
import vinicius.springframework.spring5webapp.model.Book;
import vinicius.springframework.spring5webapp.repositories.AuthorRepository;
import vinicius.springframework.spring5webapp.repositories.BookRepository;

/**
 * Criado por Vinícius Alves em 29/11/18
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {

        //Vinícius
        Author vinicius = new Author("Vinicius", "Alves");
        Book learningSpring = new Book("Learning Spring Vol. 1", "1234", "Editora Alves");
        learningSpring.getAuthors().add(vinicius);

        authorRepository.save(vinicius);
        bookRepository.save(learningSpring);

        //Barbara
        Author barbara = new Author("Barbara", "Alves");
        Book tratamentoVocal = new Book("Tratamento Vocal", "2345", "Editora Alves");
        barbara.getBooks().add(tratamentoVocal);

        authorRepository.save(barbara);
        bookRepository.save(tratamentoVocal);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
