package com.springfwguru.Spring5LibraryApp.bootstrap;

import com.springfwguru.Spring5LibraryApp.model.entities.*;
import com.springfwguru.Spring5LibraryApp.model.repositories.AuthorRepository;
import com.springfwguru.Spring5LibraryApp.model.repositories.BookRepository;
import com.springfwguru.Spring5LibraryApp.model.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeData();
    }

    private void initializeData()
    {
        // Publishers
        Publisher pHall   = new Publisher("Prentice Hall", "1010 Prentice Road");
        Publisher aWesley = new Publisher("Addison-Wesley", "3000 Addison Road");

        publisherRepository.save(pHall);
        publisherRepository.save(aWesley);

        //
        // Authors & Books
        //

        // Robert C. Martin
        Author rMartin = new Author("Robert C.", "Martin");
        Book rmBook  = new Book("Clean Code","12345");
        rMartin.getBooks().add(rmBook);
        rmBook.getAuthors().add(rMartin);
        rmBook.setPublisher(pHall);

        authorRepository.save(rMartin);
        bookRepository.save(rmBook);

        // Joshua Bloch
        Author jBloch = new Author("Joshua", "Block");
        Book jbBook  = new Book("Effective Java, Third Edition","1234567");
        jBloch.getBooks().add(jbBook);
        jbBook.getAuthors().add(jBloch);
        jbBook.setPublisher(aWesley);

        authorRepository.save(jBloch);
        bookRepository.save(jbBook);
    }
}
