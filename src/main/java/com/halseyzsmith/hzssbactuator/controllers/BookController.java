package com.halseyzsmith.hzssbactuator.controllers;

import com.halseyzsmith.hzssbactuator.domain.Book;
import com.halseyzsmith.hzssbactuator.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable Integer id, Model model) {

        Book book = bookService.getBookById(id);

        List<Book> categoryBooks = bookService.getBooksByCategories(book.getCategories());
        categoryBooks.remove(book);

        model.addAttribute("book", book);
        model.addAttribute("books", categoryBooks);
        return "book";
    }
}
