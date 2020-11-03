package com.halseyzsmith.hzssbactuator.controllers.api;

import com.halseyzsmith.hzssbactuator.domain.Author;
import com.halseyzsmith.hzssbactuator.domain.Book;
import com.halseyzsmith.hzssbactuator.services.AuthorService;
import com.halseyzsmith.hzssbactuator.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorAPIController {

    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getBookByAuthor(@PathVariable Integer id) {
        Author author = authorService.getAuthorById(id);
        return bookService.getBooksByAuthor(author);
    }
}
