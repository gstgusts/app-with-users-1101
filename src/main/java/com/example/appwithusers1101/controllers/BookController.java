package com.example.appwithusers1101.controllers;

import com.example.appwithusers1101.data.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private UserRepository repo;

    public BookController() {
        repo = new UserRepository();
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        var books = repo.getBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
