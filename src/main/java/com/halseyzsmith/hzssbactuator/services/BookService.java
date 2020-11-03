package com.halseyzsmith.hzssbactuator.services;

import com.halseyzsmith.hzssbactuator.domain.Author;
import com.halseyzsmith.hzssbactuator.domain.Book;
import com.halseyzsmith.hzssbactuator.domain.Category;
import com.halseyzsmith.hzssbactuator.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> getBooksByAuthor(Author author) {
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> getBooksByCategories(List<Category> categories) {
        List<Book> books = bookRepository.findAllByCategoriesIn(categories);
        return new ArrayList<>(
                new HashSet<>(books)
        );
    }
}
