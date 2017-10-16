package com.springfwguru.Spring5LibraryApp.model.repositories;

import com.springfwguru.Spring5LibraryApp.model.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
