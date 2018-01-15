package com.springfwguru.Spring5LibraryApp.controllers;

import com.springfwguru.Spring5LibraryApp.model.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublisherController {
    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository)
    {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping(value = "/publishers", method = RequestMethod.GET)
    public String publishers(Model model)
    {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publishers";
    }
}
