package com.halseyzsmith.hzssbactuator.controllers;

import com.halseyzsmith.hzssbactuator.domain.Author;
import com.halseyzsmith.hzssbactuator.services.AuthorService;
import com.halseyzsmith.hzssbactuator.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/author/{id}")
    public String getAuthorById(@PathVariable Integer id, Model model) {

        Author author = authorService.getAuthorById(id);

        model.addAttribute("author", author);
        model.addAttribute("books", bookService.getBooksByAuthor(author));
        return "author";
    }
}
