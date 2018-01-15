package com.springfwguru.Spring5LibraryApp.controllers;

import com.springfwguru.Spring5LibraryApp.model.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String authors(Model model)
    {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
