package com.springfwguru.Spring5LibraryApp.controllers;

import com.springfwguru.Spring5LibraryApp.model.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Adama on 2017-12-17.
 */
@Controller
public class BookController
{
    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAllBooks(Model model)
    {
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
