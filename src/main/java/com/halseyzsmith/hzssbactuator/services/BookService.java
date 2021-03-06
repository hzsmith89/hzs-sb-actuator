package com.halseyzsmith.hzssbactuator.services;

import com.halseyzsmith.hzssbactuator.domain.Author;
import com.halseyzsmith.hzssbactuator.domain.Book;
import com.halseyzsmith.hzssbactuator.domain.Category;
import com.halseyzsmith.hzssbactuator.repositories.BookRepository;
import com.halseyzsmith.hzssbactuator.services.jms.JmsTextMessageService;
import io.micrometer.core.instrument.Metrics;
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
    private final JmsTextMessageService jmsTextMessageService;

    public List<Book> getBooks() {
        jmsTextMessageService.sendTextMessage("Getting all books...");
        Metrics.counter("BookService.getBooks").increment();
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Book getBookById(Integer id) {
        jmsTextMessageService.sendTextMessage("Getting book with id: " + id);
        Metrics.counter("BookService.getBookById").increment();
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> getBooksByAuthor(Author author) {
        jmsTextMessageService.sendTextMessage("Getting books by author: " + author.getFullName());
        Metrics.counter("BookService.getBooksByAuthor").increment();
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> getBooksByCategories(List<Category> categories) {
        jmsTextMessageService.sendTextMessage("Getting books with categories " + categories.toString());
        List<Book> books = bookRepository.findAllByCategoriesIn(categories);
        Metrics.counter("BookService.getBooksByCategory").increment();
        return new ArrayList<>(new HashSet<>(books));
    }
}
