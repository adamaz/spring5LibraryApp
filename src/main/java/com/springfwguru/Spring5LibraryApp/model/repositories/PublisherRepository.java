package com.springfwguru.Spring5LibraryApp.model.repositories;

import com.springfwguru.Spring5LibraryApp.model.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
